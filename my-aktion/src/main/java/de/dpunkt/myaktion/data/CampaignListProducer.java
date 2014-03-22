package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.services.CampaignService;
import de.dpunkt.myaktion.util.Events.Added;
import de.dpunkt.myaktion.util.Events.Deleted;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class CampaignListProducer implements Serializable {

    private static final long serialVersionUID = -182866064791747156L;
    private List<Campaign> campaigns;

    @Inject
    private CampaignService campaignService;

    @PostConstruct
    public void init() {
        campaigns = campaignService.getAllCampaigns();
    }

    @Produces
    @Named
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void onCampaignAdded(@Observes @Added Campaign campaign) {
        getCampaigns().add(campaign);
    }

    public void onCampaignDeleted(@Observes @Deleted Campaign campaign) {
        getCampaigns().remove(campaign);
    }

}
