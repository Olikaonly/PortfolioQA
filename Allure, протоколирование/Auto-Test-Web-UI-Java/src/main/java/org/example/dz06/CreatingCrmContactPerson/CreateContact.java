package org.example.dz06.CreatingCrmContactPerson;

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
public class CreateContact extends BaseView {
    public CreateContact(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
    public WebElement createContactButton;

    @Step("Создать контактное лицо")
    public PageOfContactCreation allContactCreate() {
        createContactButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateExpensePage.saveAndCloseButtonXpathLocator)));
        return new PageOfContactCreation(driver);
    }

    public static final String createXpath = "//a[text()='Создать контактное лицо']";

}
