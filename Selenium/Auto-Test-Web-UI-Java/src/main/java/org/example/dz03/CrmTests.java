package org.example.dz03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Olga Shestakova
 * Date 20.08.2021
 */
public class CrmTests {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LoginToCrm();
        Thread.sleep(5000);

        driver.get("https://crm.geekbrains.space/expense-request/");
        driver.findElement(By.xpath("//a[@title= 'Создать заявку на расход']")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_expense_request[description]")));
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("Зарплата");

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("70101 - Расчеты с персоналом по оплате труда (пост. часть)");

        Select currencySelect = new Select(driver.findElement(By.name("crm_expense_request[currency]")));
        currencySelect.selectByVisibleText("Доллар США");

        driver.findElement(By.name("crm_expense_request[sumPlan]")).sendKeys("10000");

        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]")).click();
        driver.findElement(By.xpath("//a[text()='21']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();


        Thread.sleep(5000);

        driver.quit();

    }

    public static void LoginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.xpath("//button")).click();

    }
}
