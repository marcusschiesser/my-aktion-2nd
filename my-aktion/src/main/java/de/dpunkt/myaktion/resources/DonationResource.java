package de.dpunkt.myaktion.resources;

import de.dpunkt.myaktion.model.Account;
import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.model.Donation.Status;
import de.dpunkt.myaktion.services.DonationService;
import de.dpunkt.myaktion.services.exceptions.ObjectNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class DonationResource {

    @Inject
    private DonationService donationService;

    @GET
    @Path("/organizer/donation/list/{campaignId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Donation> getDonationList(@PathParam(value = "campaignId") Long campaignId) {
        List<Donation> donations = donationService.getDonationList(campaignId);
        donations.forEach(donation -> donation.setCampaign(null));
        return donations;
    }

    @POST
    @Path("/donation/{campaignId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDonation(@PathParam(value = "campaignId") Long campaignId,
                            @FormParam(value = "donorName") String donorName,
                            @FormParam(value = "amount") Double amount,
                            @FormParam(value = "iban") String iban,
                            @FormParam(value = "nameOfBank") String nameOfBank,
                            @FormParam(value = "receiptRequested") Boolean receiptRequested) {
        Donation donation = new Donation();
        donation.setDonorName(donorName);
        donation.setAmount(amount);
        Account account = new Account();
        account.setIban(iban);
        account.setName(donorName);
        account.setNameOfBank(nameOfBank);
        donation.setAccount(account);
        donation.setReceiptRequested(receiptRequested);
        donation.setStatus(Status.IN_PROCESS);
        donationService.addDonation(campaignId, donation);
    }

    @GET
    @Path("/donation/list/{campaignId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDonationListPublic(@PathParam(value = "campaignId") Long campaignId) {
        List<Donation> donations;
        try {
            donations = donationService.getDonationListPublic(campaignId);
            return Response.ok(donations).build();
        } catch (ObjectNotFoundException e) {
            return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
        }
    }

}
