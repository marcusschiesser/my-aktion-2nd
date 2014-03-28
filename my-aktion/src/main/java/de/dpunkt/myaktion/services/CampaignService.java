package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> getAllCampaigns();

    void addCampaign(Campaign campaign);

    void deleteCampaign(Campaign campaign);

    void updateCampaign(Campaign campaign);
}
