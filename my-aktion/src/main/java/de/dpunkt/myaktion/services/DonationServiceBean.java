package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Donation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class DonationServiceBean implements DonationService {
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Donation> getDonationList(Long campaignId) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
        List<Donation> donations = managedCampaign.getDonations();
        return donations;
    }

    @Override
    public void addDonation(Long campaignId, Donation donation) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
        donation.setCampaign(managedCampaign);
        entityManager.persist(donation);
    }
}
