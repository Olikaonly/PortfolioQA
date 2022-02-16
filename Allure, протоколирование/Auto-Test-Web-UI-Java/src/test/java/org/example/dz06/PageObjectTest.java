package org.example.dz06;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
@Story("Заявки на расходы")
public class PageObjectTest extends BaseTest {

    @Test
    @Description("Тест логина и создания заявки на расход")
    void loginInCrmWithPageObjTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/user/login");
        new LoginPage(driver)
                .fillInputLogin("user")
                .fillInputPassword("1234")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Расходы");

        new ExpensesSubMenu(driver).goToExpensesRequestsPage();

        new ExpensesRequestsPage(driver)
                .createExpense()
                .fillName("Зарплата")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("70101 - Расчеты с персоналом по оплате труда (пост. часть)")
                .selectCurrency("Доллар США")
                .fillSumPlan("10000")
                .selectDatePlan("20")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new CreateExpensePage(driver).requestSavedSuccessfullyElement, isDisplayed());
    }
}
