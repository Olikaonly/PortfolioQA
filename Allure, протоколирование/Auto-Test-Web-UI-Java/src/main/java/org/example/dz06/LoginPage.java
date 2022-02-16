package org.example.dz06;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @Step("Заполнить поле логина")
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку логина")
    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
    }
}
