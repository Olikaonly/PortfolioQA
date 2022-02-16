package org.example.dz06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class BaseView {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
