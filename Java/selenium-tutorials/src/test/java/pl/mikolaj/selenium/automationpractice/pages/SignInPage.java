package pl.mikolaj.selenium.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement createAccEmailInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAccButton;

    public SignInPage enterCreateAccEmail() {
        createAccEmailInput.sendKeys(faker.internet().emailAddress());
        return this;
    }

    public CreateAccountPage pressCreateAccButton() {
        createAccButton.click();
        return new CreateAccountPage();
    }
}
