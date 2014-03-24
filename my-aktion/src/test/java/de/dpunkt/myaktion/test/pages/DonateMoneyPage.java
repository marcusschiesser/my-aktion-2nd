package de.dpunkt.myaktion.test.pages;

import de.dpunkt.myaktion.model.Donation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

public class DonateMoneyPage extends AbstractPage {
    @FindBy(xpath = "//input[contains(@id,'name')]")
    private WebElement name;
    @FindBy(xpath = "//input[contains(@id,'iban')]")
    private WebElement iban;
    @FindBy(xpath = "//input[contains(@id,'name_bank')]")
    private WebElement nameBank;
    @FindBy(xpath = "//input[contains(@id,'donationAmount')]")
    private WebElement donationAmount;

    public void assertOnPage() {
        assertTitle("donateMoney.donate_money");
    }

    public void setDonation(Donation donation) {
        name.sendKeys(donation.getDonorName());
        iban.sendKeys(donation.getAccount().getIban());
        nameBank.sendKeys(donation.getAccount().getNameOfBank());
        donationAmount.sendKeys(donation.getAmount().toString());
    }

    public void doDonation() {
        guardHttp(getButtonByLabel("donateMoney.donate")).click();
    }

    public void assertThankYou() {
        assertFacesMessages("donateMoney.thank_you");
    }
}
