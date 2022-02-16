package org.example.dz06.CreatingCrmContactPerson;

import org.example.dz06.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class PageOfContactCreation extends BaseView {
    public PageOfContactCreation(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement lastName;

    public PageOfContactCreation crmLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    public PageOfContactCreation crmFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    public PageOfContactCreation crmJobTitle(String name) {
        jobTitle.sendKeys(name);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Значение не должно быть пустым.']")
    public WebElement requestSaveOneElement;

}
