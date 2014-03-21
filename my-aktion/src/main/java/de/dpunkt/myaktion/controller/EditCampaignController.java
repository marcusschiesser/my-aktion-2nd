package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignListProducer;
import de.dpunkt.myaktion.data.CampaignProducer;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class EditCampaignController implements Serializable {
    private static final long serialVersionUID = 2815796004558360299L;

    @Inject
    private CampaignListProducer campaignListProducer;

    @Inject
    private CampaignProducer campaignProducer;

    public String doSave() {
        if (campaignProducer.isAddMode()) {
            campaignListProducer.getCampaigns().add(campaignProducer.getSelectedCampaign());
        }
        return Pages.LIST_CAMPAIGNS;
    }

    public String doCancel() {
        return Pages.LIST_CAMPAIGNS;
    }

}
