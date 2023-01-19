package com.learning.pages;

import com.learning.driver.DriverManager;
import com.learning.enums.WaitStrategy;
import com.learning.reports.ExtentSpark;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class OrangeHRMLoginPage extends BasePage {
    private final By textboxUsername = By.xpath("//input[@name=\"username\"]");
    private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By buttonLogin = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username) {
//        new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(textboxUsername));
//        DriverManager.getDriverThreadLocal().findElement(textboxUsername).sendKeys(username);
//        sendKeys(textboxUsername, username, "Present");
        sendKeys(textboxUsername, username, WaitStrategy.PRESCENCE);
        ExtentSpark.test.pass("Entered Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
//        DriverManager.getDriverThreadLocal().findElement(textboxPassword).sendKeys(password);
        sendKeys(textboxPassword, password, WaitStrategy.PRESCENCE);
        ExtentSpark.test.pass("Entered Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
//        DriverManager.getDriverThreadLocal().findElement(buttonLogin).click();
        click(buttonLogin, WaitStrategy.CLICKABLE);
        ExtentSpark.test.pass("Clicked login button");
        return new OrangeHRMHomePage();
    }

    public String getTitle() {

//        return DriverManager.getDriverThreadLocal().getTitle();
        return getPageTitle();
    }
}
