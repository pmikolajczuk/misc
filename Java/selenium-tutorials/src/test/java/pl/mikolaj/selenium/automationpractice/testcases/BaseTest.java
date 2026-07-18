package pl.mikolaj.selenium.automationpractice.testcases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pl.mikolaj.selenium.config.WebDriverSingleton;

public class BaseTest {

    @BeforeEach
    void setUp() {
        WebDriverSingleton.getInstance().get("http://automationpractice.com/");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverSingleton.quit();
    }
}
