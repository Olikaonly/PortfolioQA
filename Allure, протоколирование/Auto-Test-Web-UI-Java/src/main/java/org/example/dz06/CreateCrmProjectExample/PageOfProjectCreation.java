package org.example.dz06.CreateCrmProjectExample;

import io.qameta.allure.Step;
import org.example.dz06.BaseView;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class PageOfProjectCreation extends BaseView {
    public PageOfProjectCreation(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement crmProjectName;

    @Step("Заполнить имя")
    public PageOfProjectCreation crmName(String name) {
        crmProjectName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    @Step("Выбрать businessUnit")
    public PageOfProjectCreation selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement selectCurator;

    @Step("Выбрать curator")
    public PageOfProjectCreation selectCurator(String curator) {
        new Select(selectCurator).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement selectRp;

    @Step("Выбрать rp")
    public PageOfProjectCreation selectRp(String rp) {
        new Select(selectRp).selectByVisibleText(rp);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement selectAdministrator;

    @Step("Выбрать administrator")
    public PageOfProjectCreation selectAdministrator(String administrator) {
        new Select(selectAdministrator).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement selectManager;

    @Step("Выбрать manager")
    public PageOfProjectCreation selectManager(String manager) {
        new Select(selectManager).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Это значение уже используется.']")
    public WebElement requestSaveElement;
}
