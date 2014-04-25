package de.dpunkt.myaktion.test;

import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.test.pages.DonateMoneyPage;
import de.dpunkt.myaktion.test.pages.ListCampaignsPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class DonateMoneyITCase extends AbstractITCase {

    @Drone
    private WebDriver browser;
    @Page
    private DonateMoneyPage donateMoneyPage;

    @Before
    public void setupDatabase() {
        SetupDatabase.addCampaign(DataFactory.createTestCampaign());
    }

    @Test
    public void testDonateMoney(@InitialPage ListCampaignsPage listCampaignsPage) {
        final Donation donation = DataFactory.createDonation();
        SetupDatabase.addDonation(donation);
        donateMoneyPage.assertThankYou();
    }

}
