package org.example.dz03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Olga Shestakova
 * Date 20.08.2021
 */
public class StartOfSeleniumDev {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
