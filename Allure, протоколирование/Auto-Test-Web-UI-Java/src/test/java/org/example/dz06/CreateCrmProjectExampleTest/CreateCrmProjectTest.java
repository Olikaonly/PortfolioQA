package org.example.dz06.CreateCrmProjectExampleTest;

import io.qameta.allure.Description;
import org.example.dz06.BaseTest;
import org.example.dz06.CreateCrmProjectExample.AllMenuProjects;
import org.example.dz06.CreateCrmProjectExample.CreateAProject;
import org.example.dz06.CreateCrmProjectExample.PageOfProjectCreation;
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
public class CreateCrmProjectTest extends BaseTest {
    private NavigationMenu navigationMenu;

    @Test
    @Description("Тест логина и создания проекта")
    void loginInCreateCrmProjectTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/user/login");
        new LoginPage(driver)
                .fillInputLogin("user")
                .fillInputPassword("1234")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new AllMenuProjects(driver).goAllMenuProjects();

        new CreateAProject(driver)
                .allProjectCreate()
                .crmName("New project")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectRp("Applanatest1 Applanatest1 Applanatest1")
                .selectAdministrator("Applanatest2 Applanatest2 Applanatest2")
                .selectManager("Амелин Владимир")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new PageOfProjectCreation(driver).requestSaveElement, isDisplayed());
    }
}
