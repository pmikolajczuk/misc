package pl.mikolaj.selenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver driver;
    private WebDriverSingleton() {}

    public static synchronized WebDriver getInstance() {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    public static synchronized void quit() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
