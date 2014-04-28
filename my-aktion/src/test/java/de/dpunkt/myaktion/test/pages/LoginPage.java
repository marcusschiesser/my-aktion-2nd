package de.dpunkt.myaktion.test.pages;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@Location("login.jsf")
public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='j_username']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='j_password']")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginLink;

    public void doLogin(final String email, final String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        guardHttp(loginLink).click();
    }

}
