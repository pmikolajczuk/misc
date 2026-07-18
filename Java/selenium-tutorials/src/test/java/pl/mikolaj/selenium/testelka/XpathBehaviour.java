package pl.mikolaj.selenium.testelka;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathBehaviour {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://pl.wikipedia.org/wiki/Wszech%C5%9Bwiat_Friedmana");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void xpathTest() {
        WebElement element = driver
                .findElement(By.xpath("//div[@id='toc']"))
                .findElement(By.xpath("//span[text()='Przyszłość Wszechświata']"));

    }
}
