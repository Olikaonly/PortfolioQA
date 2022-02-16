package org.example.dz06.CreatingCrmContactPersonTest;

import org.example.dz06.BaseTest;
import org.example.dz06.CreatingCrmContactPerson.CreateContact;
import org.example.dz06.CreatingCrmContactPerson.MenuContact;
import org.example.dz06.CreatingCrmContactPerson.PageOfContactCreation;
import org.example.dz06.LoginPage;
import org.example.dz06.NavigationMenu;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class CrmContactPersonTest extends BaseTest {
    private NavigationMenu navigationMenu;

    @Test
    void loginInCreateCrmProjectTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/user/login");
        new LoginPage(driver)
                .fillInputLogin("user")
                .fillInputPassword("1234")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Контрагенты");

        new MenuContact(driver).goMenuContact();

        new CreateContact(driver)
                .allContactCreate()
                .crmLastName("Шестакова")
                .crmFirstName("Ольга")
                .crmJobTitle("Студент")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new PageOfContactCreation(driver).requestSaveOneElement, isDisplayed());
    }

}
