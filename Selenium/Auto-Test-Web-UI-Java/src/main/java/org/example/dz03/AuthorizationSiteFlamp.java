package org.example.dz03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Olga Shestakova
 * Date 22.08.2021
 */

//  Сценарий авторизация на сайте Flamp

public class AuthorizationSiteFlamp {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LoginToFlamp();

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
