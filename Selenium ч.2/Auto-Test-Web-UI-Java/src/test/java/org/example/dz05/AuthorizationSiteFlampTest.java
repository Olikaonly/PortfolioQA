package org.example.dz05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.dz04.utils.TimingExtention;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Olga Shestakova
 * Date 01.09.2021
 */

@ExtendWith(TimingExtention.class)

public class AuthorizationSiteFlampTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://novosibirsk.flamp.ru/";

    @BeforeAll
    static void registerDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
    }

    @Test
    void reviewCounterToFlampTest() throws InterruptedException {
        LoginToFlamp();

        Actions actions = new Actions(driver);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'js-context-menu-holder context-menu-holder')]")));
        WebElement profileMenuElement = driver.findElement(By.xpath("//div[contains(@class, 'js-context-menu-holder context-menu-holder')]"));
        actions.moveToElement(profileMenuElement).perform();

        Thread.sleep(5000);

        List<WebElement> headersList = driver.findElements(
                By.xpath("//li[@class= 'city-statistics__item']"));

        Assertions.assertEquals("1 610 474\n" +
                "отзыва о компаниях города", headersList.get(0).getText());

        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {

        driver.quit();
    }

    public static void LoginToFlamp() {
        driver.get("https://novosibirsk.flamp.ru/");
        driver.findElement(By.xpath("//div[text()='Вход']")).click();
        driver.findElement(By.xpath("//cat-inputs-text[@type='email']/input")).sendKeys("eolgis@ngs.ru");
        driver.findElement(By.xpath("//input[contains(@type, 'password')]")).sendKeys("qwerty123456");
        driver.findElement(By.xpath("//div[text()='Войти']")).click();

    }

}
