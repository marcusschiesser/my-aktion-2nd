package de.dpunkt.myaktion.test.pages;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("editDonationForm.jsf")
public class EditDonationFormPage extends AbstractPage {
    @FindBy(xpath = "//textarea[contains(@id,'url')]")
    private WebElement formUrl;

    public void assertOnPage() {
        assertTitle("editDonationForm.edit_donation_form");
    }

    public String getFormURL() {
        return formUrl.getText();
    }
}
