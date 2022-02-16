package org.example.dz06.AuthorizationSiteFlampTest;

import io.qameta.allure.Description;
import org.example.dz06.AuthorizationSiteFlamp.LoginPageFlamp;
import org.example.dz06.BaseTest;
import org.example.dz06.NavigationMenu;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class AuthorizationSiteFlampTest extends BaseTest {
    private NavigationMenu navigationMenu;

    @Test
    @Description("Тест авторизации на сайте")
    void loginInCreateFlampTest() throws InterruptedException {
        driver.get("https://novosibirsk.flamp.ru/");
        new LoginPageFlamp(driver)
                .clickLoginButtonTheSite()
                .inputLogin("eolgis@ngs.ru")
                .inputPasswordFlamp("qwerty123456")
                .clickLoginButtonFlamp();

        Thread.sleep(5000);

        assertThat(new LoginPageFlamp(driver).saveElementFlamp, isDisplayed());

    }
}
