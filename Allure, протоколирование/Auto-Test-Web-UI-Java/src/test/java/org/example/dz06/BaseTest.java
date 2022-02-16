package org.example.dz06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.example.dz07.CustomLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class BaseTest {
    public EventFiringWebDriver driver;
    public WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    void tearDown() {
        LogEntries browserConsoleLogs = driver.manage().logs().get(LogType.BROWSER);

        Iterator<LogEntry> iterator = browserConsoleLogs.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Элемент лога браузера", iterator.next().getMessage());
        }

        driver.quit();
    }
}
