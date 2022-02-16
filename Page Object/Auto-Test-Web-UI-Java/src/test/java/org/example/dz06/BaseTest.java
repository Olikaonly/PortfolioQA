package org.example.dz06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class BaseTest {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
