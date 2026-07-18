package pl.mikolaj.selenium.testelka;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstTest {

    private WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.navigate().to("https://google.pl");
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        //*[@id="L2AGLb"]/div
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void demoTest() {
        WebElement searchField = driver.findElement(By.cssSelector("[title='Szukaj'"));
        String searchEntry = "Wszechświaty równoległe";
        String title = "Wieloświat – Wikipedia, wolna encyklopedia";
        searchField.sendKeys(searchEntry);
        searchField.submit();
        List<WebElement> wikiElements = driver.findElements(By.xpath(".//*[text()='Wieloświat – Wikipedia, wolna encyklopedia']"));
        WebElement wikiLink = wikiElements.get(1);
        wikiLink.click();
        //driver.findElement(By.xpath("//*[@id=\"rso\"]/div[8]/div/div[1]/div/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs(title));
        String entryURL = "https://pl.wikipedia.org/wiki/Wielo%C5%9Bwiat";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct");

    }


}
