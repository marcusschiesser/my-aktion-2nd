package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Donation;

import java.util.List;

public interface DonationService {
    List<Donation> getDonationList(Long campaignId);

    void addDonation(Long campaignId, Donation donation);
}
