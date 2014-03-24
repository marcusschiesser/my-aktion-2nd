package de.dpunkt.myaktion.test;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.test.pages.EditCampaignPage;
import de.dpunkt.myaktion.test.pages.ListCampaignsPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class EditCampaignITCase extends AbstractITCase {

    @Drone
    private WebDriver browser;
    @Page
    private EditCampaignPage editCampaignPage;

    @Test
    public void testAddCampaign(@InitialPage ListCampaignsPage listCampaignsPage) {
        final Campaign testCampaign = DataFactory.createTestCampaign();
        listCampaignsPage.doAddCampaign();
        editCampaignPage.assertOnPage();
        editCampaignPage.setCampaign(testCampaign);
        editCampaignPage.doSave();
        listCampaignsPage.assertOnPage();
        listCampaignsPage.assertCampaignName(testCampaign.getName());
    }

}
