package com.learning.pages;

import com.learning.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {
    private final By textboxUsername = By.xpath("//input[@name=\"username\"]");
    private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By buttonLogin = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username) {
        sendKeys(textboxUsername, username, WaitStrategy.PRESCENCE, "Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(textboxPassword, password, WaitStrategy.PRESCENCE, "Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(buttonLogin, WaitStrategy.CLICKABLE, "Login");
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
