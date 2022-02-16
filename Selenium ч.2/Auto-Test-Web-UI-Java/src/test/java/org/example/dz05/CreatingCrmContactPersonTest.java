package org.example.dz05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.dz04.utils.TimingExtention;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

public class CreatingCrmContactPersonTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        LoginToCrm();
    }

    @Test
    void saveGoPageCreatingCrmContactPersonTest() throws InterruptedException {

        Actions actions = new Actions(driver);

        WebElement contractMenuElement = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(contractMenuElement).perform();
        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Шестакова");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Ольга");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Укажите организацию']")));
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("geek");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        organizationVars.get(0).click();

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Студент");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Assert.assertEquals("Создать контактное лицо - Контактные лица - Контрагенты", driver.getTitle());


        Thread.sleep(5000);

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void LoginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.xpath("//button")).click();

    }
}
