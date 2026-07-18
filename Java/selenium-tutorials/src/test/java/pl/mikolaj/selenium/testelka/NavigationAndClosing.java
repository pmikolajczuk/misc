package pl.mikolaj.selenium.testelka;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationAndClosing {

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void navigate() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));

        driver.navigate().to("http://google.pl");
        driver.navigate().to("http://amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}
