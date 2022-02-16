package org.example.dz06.CreateCrmProjectExample;

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
public class AllMenuProjects extends BaseView {
    public AllMenuProjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement allMenuProjectsItem;

    @Step("Перейти на страницу все проекты")
    public void goAllMenuProjects() {

        allMenuProjectsItem.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(CreateAProject.createXpathLocator)));
    }
}
