package de.dpunkt.myaktion.test.pages;

import de.dpunkt.myaktion.model.Campaign;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@Location("editCampaign.jsf")
public class EditCampaignPage extends AbstractPage {
    @FindBy(xpath = "//input[contains(@id,'a_name')]")
    private WebElement campaignName;
    @FindBy(xpath = "//input[contains(@id,'a_targetAmount')]")
    private WebElement targetAmount;
    @FindBy(xpath = "//input[contains(@id,'a_donationMinimum')]")
    private WebElement donationMinimum;

    @FindBy(xpath = "//input[contains(@id,'b_name')]")
    private WebElement accountName;
    @FindBy(xpath = "//input[contains(@id,'b_iban')]")
    private WebElement iban;
    @FindBy(xpath = "//input[contains(@id,'b_name_bank')]")
    private WebElement nameBank;

    public void setCampaign(Campaign campaign) {
        campaignName.sendKeys(campaign.getName());
        targetAmount.sendKeys(campaign.getTargetAmount().toString());
        donationMinimum.sendKeys(campaign.getDonationMinimum().toString());
        getTabButtonByLabel("editCampaign.bank_account").click();
        accountName.sendKeys(campaign.getAccount().getName());
        iban.sendKeys(campaign.getAccount().getIban());
        nameBank.sendKeys(campaign.getAccount().getNameOfBank());
    }

    public void doSave() {
        guardHttp(getButtonByLabel("editCampaign.save")).click();
    }

    public void assertOnPage() {
        assertTitle("editCampaign.add_new_campaign");
    }

}
