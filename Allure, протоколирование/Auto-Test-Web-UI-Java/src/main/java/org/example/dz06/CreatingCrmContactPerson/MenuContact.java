package org.example.dz06.CreatingCrmContactPerson;

import io.qameta.allure.Step;
import org.example.dz06.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class MenuContact extends BaseView {
    public MenuContact(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement menuContactItem;

    @Step("Перейти на страницу контактные лица")
    public void goMenuContact() {

        menuContactItem.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(CreateContact.createXpath)));
    }
}
