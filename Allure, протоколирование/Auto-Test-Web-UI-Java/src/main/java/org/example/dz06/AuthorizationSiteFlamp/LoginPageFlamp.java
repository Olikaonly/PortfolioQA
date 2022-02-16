package org.example.dz06.AuthorizationSiteFlamp;

import io.qameta.allure.Step;
import org.example.dz06.BaseView;
import org.example.dz06.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class LoginPageFlamp extends BaseView {
    public LoginPageFlamp(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[text()='Вход']")
    public WebElement enterTheSite;

    @Step("Клик на кнопку вход")
    public LoginPageFlamp clickLoginButtonTheSite() {
        enterTheSite.click();
        return this;
    }

    @FindBy(xpath = "//cat-inputs-text[@type='email']/input")
    public WebElement inputEmail;

    @Step("Заполнить поле логина")
    public LoginPageFlamp inputLogin(String login) {
        inputEmail.sendKeys(login);
        return this;
    }

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    public WebElement inputPassword;

    @Step("Заполнить поле пароля")
    public LoginPageFlamp inputPasswordFlamp(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//div[text()='Войти']")
    public WebElement loginButton;

    @Step("Клик на кнопку войти")
    public MainPage clickLoginButtonFlamp() {
        loginButton.click();
        return new MainPage(driver);
    }

    @FindBy(xpath = "//*[text()='\n" +
            "\t\t\t\t\t\t\t\t\t\t\tНайдите друзей\n" +
            "\t\t\t\t\t\t\t\t\t\t']")
    public WebElement saveElementFlamp;
}
