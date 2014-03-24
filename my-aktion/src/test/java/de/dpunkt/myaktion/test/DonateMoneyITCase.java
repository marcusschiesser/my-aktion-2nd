package de.dpunkt.myaktion.test;

import de.dpunkt.myaktion.test.pages.DonateMoneyPage;
import de.dpunkt.myaktion.test.pages.EditDonationFormPage;
import de.dpunkt.myaktion.test.pages.ListCampaignsPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class DonateMoneyITCase extends AbstractITCase {

    @Drone
    private WebDriver browser;
    @Page
    private EditDonationFormPage editDonationFormPage;
    @Page
    private DonateMoneyPage donateMoneyPage;

    @Test
    public void testDonateMoney(@InitialPage ListCampaignsPage listCampaignsPage) {
        listCampaignsPage.clickCampaignUrl();
        editDonationFormPage.assertOnPage();
        browser.get(editDonationFormPage.getFormURL());
        donateMoneyPage.assertOnPage();
        donateMoneyPage.setDonation(DataFactory.createDonation());
        donateMoneyPage.doDonation();
        donateMoneyPage.assertThankYou();
    }

}
