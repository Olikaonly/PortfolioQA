package org.example.dz06.CreateCrmProjectExample;

import io.qameta.allure.Step;
import org.example.dz06.BaseView;
import org.example.dz06.CreateExpensePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class CreateAProject extends BaseView {
    public CreateAProject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;

    @Step("Создать проект")
    public PageOfProjectCreation allProjectCreate() {
        createProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateExpensePage.saveAndCloseButtonXpathLocator)));
        return new PageOfProjectCreation(driver);
    }
    public static final String createXpathLocator = "//a[text()='Создать проект']";
}
