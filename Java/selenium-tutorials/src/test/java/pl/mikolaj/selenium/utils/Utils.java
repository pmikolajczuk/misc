package pl.mikolaj.selenium.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.mikolaj.selenium.config.WebDriverSingleton;

import java.time.Duration;

public class Utils {
    static final Duration WAIT_DURATION = Duration.ofSeconds(10);
    private static WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), WAIT_DURATION);

    public static void waitForElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
