package org.example.dz06;

import org.openqa.selenium.WebDriver;

/**
 * Created by Olga Shestakova
 * Date 06.09.2021
 */
public class MainPage extends BaseView {
    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }
}
