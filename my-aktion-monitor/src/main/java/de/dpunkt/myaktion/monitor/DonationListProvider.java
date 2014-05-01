package de.dpunkt.myaktion.monitor;

import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.model.DonationListMBR;
import de.dpunkt.myaktion.monitor.util.DisableHostnameVerifier;

import javax.enterprise.context.Dependent;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Dependent
public class DonationListProvider {
    private static final String REST_HOST = "localhost";
    private static final int REST_PORT = 8443;

    private static final String REST_DONATION_LIST = "https://" + REST_HOST + ":"
            + REST_PORT + "/my-aktion/rest/donation/list/";

    private Client restClient;

    public DonationListProvider() {
        ClientBuilder builder = ClientBuilder.newBuilder();
        builder.register(DonationListMBR.class);
        builder.hostnameVerifier(new DisableHostnameVerifier());
        restClient = builder.build();
    }

    public List<Donation> getDonationList(long campaignId) throws WebApplicationException {
        WebTarget target = restClient.target(REST_DONATION_LIST + campaignId);
        GenericType<List<Donation>> list = new GenericType<List<Donation>>() {
        };
        List<Donation> donations = target.request(MediaType.APPLICATION_JSON).get(list);
        return donations;
    }

}
