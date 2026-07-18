package pl.mikolaj.selenium.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "[title='Log in to your customer account']")
    WebElement signInButton;

    @FindBy(xpath = "//div[@id='contact-link']")
    WebElement contactUsButton;

    public SignInPage pressSignInButton() {
        signInButton.click();
        return new SignInPage();
    }

    public ContactUsPage pressContactUsButton() {
        contactUsButton.click();
        return new ContactUsPage();
    }
}
