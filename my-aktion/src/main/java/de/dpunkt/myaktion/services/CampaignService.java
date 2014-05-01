package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> getAllCampaigns();

    Campaign addCampaign(Campaign campaign);

    void deleteCampaign(Campaign campaign);

    Campaign updateCampaign(Campaign campaign);

    void deleteCampaign(Long campaignId);

    Campaign getCampaign(Long campaignId);
}
