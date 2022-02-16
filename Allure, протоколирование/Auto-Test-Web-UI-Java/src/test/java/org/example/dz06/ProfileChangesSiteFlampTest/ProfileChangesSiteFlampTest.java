package org.example.dz06.ProfileChangesSiteFlampTest;

import io.qameta.allure.Description;
import org.example.dz06.AuthorizationSiteFlamp.LoginPageFlamp;
import org.example.dz06.BaseTest;
import org.example.dz06.NavigationMenu;
import org.example.dz06.ProfileChangesSiteFlamp.ChangeProfilePage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class ProfileChangesSiteFlampTest extends BaseTest {
    private NavigationMenu navigationMenu;

    @Test
    @Description("Тест логина и изменения профиля")
    void profileСhangeFlampTest() throws InterruptedException {
        driver.get("https://novosibirsk.flamp.ru/");
        new LoginPageFlamp(driver)
                .clickLoginButtonTheSite()
                .inputLogin("eolgis@ngs.ru")
                .inputPasswordFlamp("qwerty123456")
                .clickLoginButtonFlamp();

        Thread.sleep(10000);

        new ChangeProfilePage(driver)
                .contextMenuHolderClick()
                .myProfileClick()
                .editProfileClick()
                .genderSelectionClick()
                .saveProfileClick();

        Assert.assertEquals("https://novosibirsk.flamp.ru/profile", driver.getCurrentUrl());
    }
}
