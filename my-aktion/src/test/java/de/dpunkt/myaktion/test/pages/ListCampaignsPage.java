package de.dpunkt.myaktion.test.pages;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.junit.Assert.assertEquals;

@Location("listCampaigns.jsf")
public class ListCampaignsPage extends AbstractPage {
    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    private WebElement lastCampaignName;

    @FindBy(xpath = "//tbody/tr[last()]/td[7]/a")
    private WebElement lastEditFormLink;

    public void assertOnPage() {
        assertTitle("listCampaigns.my_campaigns");
    }

    public void assertCampaignName(String campaignName) {
        assertEquals(campaignName, lastCampaignName.getText());
    }

    public void doAddCampaign() {
        WebElement addCampaignButton = getButtonByLabel("listCampaigns.add_campaign");
        guardHttp(addCampaignButton).click();
    }

    public void clickCampaignUrl() {
        guardHttp(lastEditFormLink).click();
    }
}
