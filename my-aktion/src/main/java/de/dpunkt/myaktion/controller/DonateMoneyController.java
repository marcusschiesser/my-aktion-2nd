package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Donation;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@SessionScoped
@Named
public class DonateMoneyController implements Serializable {
    private static final long serialVersionUID = 5493038842003809106L;

    private String textColor = "000000";
    private String bgColor = "ffffff";
    private Long campaignId;
    private Donation donation;

    public DonateMoneyController() {
        this.donation = new Donation();
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
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

    public String doDonation() {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final ResourceBundle resourceBundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
        final String msg = resourceBundle.getString("donateMoney.thank_you");
        facesContext.addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
        this.donation = new Donation();
        return Pages.DONATE_MONEY;
    }

}
