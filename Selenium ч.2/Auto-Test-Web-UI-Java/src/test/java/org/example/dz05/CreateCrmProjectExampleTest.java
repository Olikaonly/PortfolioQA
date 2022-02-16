package org.example.dz05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.dz04.utils.TimingExtention;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.example.dz05.utils.ColorMatcher.hasColor;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Olga Shestakova
 * Date 01.09.2021
 */

@ExtendWith(TimingExtention.class)

public class CreateCrmProjectExampleTest {
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
    void colorSaveErrorCreateCrmProjectTest() throws InterruptedException {

        Actions actions = new Actions(driver);

        WebElement projectMenuElement = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuElement).perform();
        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("New_project");

        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Укажите организацию']")));
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        organizationVars.get(0).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1111");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Планирование");
        driver.switchTo().parentFrame();

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select projectRpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectRpSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");

        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Амелин Владимир");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);

        String color = driver.findElement(By.xpath("//span[@class = 'validation-failed']")).getCssValue("color");
        assertThat(driver.findElement(By.xpath("//span[@class = 'validation-failed']")).getCssValue("color")
                , is("rgba(200, 23, 23, 1)"));
        assertThat(driver.findElement(By.xpath("//span[@class = 'validation-failed']")), hasColor("rgba(200, 23, 23, 1)"));


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
