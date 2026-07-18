package pl.mikolaj.selenium.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {

    @FindBy(id = "id_contact")
    WebElement subjectHeadingSelect;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "id_order")
    WebElement orderReference;

    @FindBy(id = "fileUpload")
    WebElement chooseFile;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(id = "submitMessage")
    WebElement submitMessageButton;

    @FindBy(xpath = "//li[text()='Invalid email address.']")
    WebElement invalidEmailMessage;

    @FindBy(xpath = "//p[text()='Your message has been successfully sent to our team.']")
    WebElement messageSentSuccessfulMessage;

    public ContactUsPage fillContactUsForm() {
        new Select(subjectHeadingSelect).selectByVisibleText("Customer service");
        email.sendKeys(faker.internet().emailAddress());
        orderReference.sendKeys(faker.number().digits(8));

        chooseFile.sendKeys("c:\\DEV\\IdeaProjects\\selenium-tutorials\\src\\main\\resources\\dummy.txt");
        message.sendKeys("Test message");
        return this;
    }

    public ContactUsPage submitForm() {
        submitMessageButton.click();
        return this;
    }

    public boolean isInvalidEmailMessageDisplayed() {
        return invalidEmailMessage.isDisplayed();
    }

    public boolean isMessageSentSuccessfulMessageDisplayed() {
        return messageSentSuccessfulMessage.isDisplayed();
    }
}
