package org.example.dz06.ProfileChangesSiteFlamp;

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
public class ChangeProfilePage extends BaseView {
    public ChangeProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'js-context-menu-holder context-menu-holder')]")
    public WebElement contextMenuHolder;

    @Step("Клик на context-menu-holder")
    public ChangeProfilePage contextMenuHolderClick() {
        contextMenuHolder.click();
        return this;
    }

    @FindBy(xpath = "//a[contains(text(), 'Мой профиль')]")
    public WebElement myProfile;

    @Step("Клик на Мой профиль")
    public ChangeProfilePage myProfileClick() throws InterruptedException {
        myProfile.click();
        Thread.sleep(10000);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Редактировать')]")
    public WebElement editProfile;

    @Step("Клик на Редактировать")
    public ChangeProfilePage editProfileClick() throws InterruptedException {
        editProfile.click();
        Thread.sleep(10000);
        return this;
    }

    @FindBy(xpath = "//span[contains(text(), 'Женский')]")
    public WebElement genderSelection;

    @Step("Клик на кнопку Женский")
    public ChangeProfilePage genderSelectionClick() throws InterruptedException {
        genderSelection.click();
        Thread.sleep(10000);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Сохранить')]")
    public WebElement saveProfile;

    @Step("Клик на кнопку Сохранить")
    public ChangeProfilePage saveProfileClick() {
        saveProfile.click();
        return this;
    }

}
