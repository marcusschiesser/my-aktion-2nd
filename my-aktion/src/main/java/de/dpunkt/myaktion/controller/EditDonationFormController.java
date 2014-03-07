package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignProducer;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@SessionScoped
@Named
public class EditDonationFormController implements Serializable {

    private static final long serialVersionUID = -4210085664588144340L;

    private String textColor = "000000";
    private String bgColor = "ffffff";

    @Inject
    private CampaignProducer campaignProducer;

    public String doOk() {
        return Pages.LIST_CAMPAIGNS;
    }

    private String getAppUrl() {
        HttpServletRequest req =
                (HttpServletRequest) FacesContext.getCurrentInstance()
                        .getExternalContext().getRequest();

        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int serverPort = req.getServerPort();
        String contextPath = req.getContextPath();

        return scheme + "://" + serverName + ":" + serverPort + contextPath;
    }

    public String getUrl() {
        return getAppUrl() + "/" + Pages.DONATE_MONEY + ".jsf" + "?bgColor=" + bgColor
                + "&textColor=" + textColor + "&campaignId=" + campaignProducer.getSelectedCampaign().getId();
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

}
