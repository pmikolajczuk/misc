package pl.mikolaj.selenium.automationpractice.testcases;

import org.junit.jupiter.api.Test;
import pl.mikolaj.selenium.automationpractice.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTest extends BaseTest {

    @Test
    public void testContactUsFormEmpty() {
        assertTrue(
                new HomePage()
                        .pressContactUsButton()
                        .submitForm()
                        .isInvalidEmailMessageDisplayed()
        );

    }

    @Test
    public void testContactUsFormCorrect() {
        assertTrue(
                new HomePage()
                        .pressContactUsButton()
                        .fillContactUsForm()
                        .submitForm()
                        .isMessageSentSuccessfulMessageDisplayed()
        );
    }

}
