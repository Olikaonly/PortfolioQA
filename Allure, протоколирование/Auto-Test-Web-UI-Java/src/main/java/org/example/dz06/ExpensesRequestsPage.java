package org.example.dz06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class ExpensesRequestsPage extends BaseView {
    public ExpensesRequestsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createExpenseXpathLocator)
    public WebElement createExpenseButton;

    @Step("Создать заявку на расход")
    public CreateExpensePage createExpense() {

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Создать заявку на расход']")));

        createExpenseButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateExpensePage.saveAndCloseButtonXpathLocator)));
        return new CreateExpensePage(driver);
    }

    public static final String createExpenseXpathLocator = "//a[text()='Создать заявку на расход']";

}
