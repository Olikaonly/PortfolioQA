package org.example.dz03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Olga Shestakova
 * Date 22.08.2021
 */

//  Сценарий редактирования профиля на сайте Flamp

public class ProfileChangesSiteFlamp {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        LoginToFlamp();

        Actions actions = new Actions(driver);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'js-context-menu-holder context-menu-holder')]")));
        WebElement profileMenuElement = driver.findElement(By.xpath("//div[contains(@class, 'js-context-menu-holder context-menu-holder')]"));
        actions.moveToElement(profileMenuElement).perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Мой профиль')]")));
        driver.findElement(By.xpath("//a[contains(text(), 'Мой профиль')]")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Редактировать')]")));
        driver.findElement(By.xpath("//div[contains(text(), 'Редактировать')]")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Женский')]")));
        driver.findElement(By.xpath("//span[contains(text(), 'Женский')]")).click();

        driver.findElement(By.xpath("//div[contains(text(), 'Сохранить')]")).click();

        Thread.sleep(5000);

        driver.quit();

    }

    public static void LoginToFlamp() {
        driver.get("https://novosibirsk.flamp.ru/");
        driver.findElement(By.xpath("//div[text()='Вход']")).click();
        driver.findElement(By.xpath("//div[2]/div/cat-inputs-text/input[@type='text']")).sendKeys("eolgis@ngs.ru");
        driver.findElement(By.xpath("//input[contains(@type, 'password')]")).sendKeys("qwerty123456");
        driver.findElement(By.xpath("//div[text()='Войти']")).click();

    }
}
