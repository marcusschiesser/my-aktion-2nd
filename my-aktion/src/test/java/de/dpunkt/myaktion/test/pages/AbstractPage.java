package de.dpunkt.myaktion.test.pages;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public abstract class AbstractPage {
    @Drone
    private WebDriver browser;

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//span[@class='ui-messages-info-summary']")
    private WebElement facesMessages;

    private String getString(String key) {
        return ResourceBundle.getBundle("messages", Locale.GERMAN).getString(key);
    }

    protected WebElement getButtonByLabel(String label) {
        return browser.findElement(By.xpath("//button/span[text()='" + getString(label) + "']"));
    }

    protected WebElement getTabButtonByLabel(String label) {
        return browser.findElement(By.xpath("//li/a[text()='" + getString(label) + "']"));
    }

    protected void assertTitle(String key) {
        assertEquals(getString(key), title.getText());
    }

    protected void assertFacesMessages(String key) {
        assertEquals(getString(key), facesMessages.getText());
    }
}
