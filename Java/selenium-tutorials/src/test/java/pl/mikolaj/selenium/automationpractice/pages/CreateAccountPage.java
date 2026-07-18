package pl.mikolaj.selenium.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement mrGenderRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(css = "[class='alert alert-danger'")
    private WebElement registrationErrorMessage;

    public CreateAccountPage fillRegistrationForm() {
        mrGenderRadioButton.click();
        this.firstName.sendKeys(faker.name().firstName());
        this.lastName.sendKeys(faker.name().lastName());
        this.password.sendKeys(faker.internet().password());
        //TODO: finish me

        return this;
    }

    public CreateAccountPage pressRegisterButton() {
        this.registerButton.click();
        return this;
    }

    public boolean isRegistrationErrorMessageDisplayed() {
        return this.registrationErrorMessage.isDisplayed();
    }
}
