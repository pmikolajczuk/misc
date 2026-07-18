package pl.mikolaj.selenium.automationpractice.testcases;

import org.junit.jupiter.api.Test;
import pl.mikolaj.selenium.automationpractice.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAccountTest extends BaseTest {

    @Test
    public void testCreateAccFailure() {
        assertTrue(
                new HomePage()
                        .pressSignInButton()
                        .enterCreateAccEmail()
                        .pressCreateAccButton()
                        .pressRegisterButton()
                        .isRegistrationErrorMessageDisplayed()
        );

    }
}
