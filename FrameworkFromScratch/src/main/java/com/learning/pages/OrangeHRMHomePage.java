package com.learning.pages;

import com.learning.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {
    private final By imgProfileIcon = By.xpath("//span[@class='oxd-userdropdown-tab']/img");
    private final By linkLogout = By.xpath("//a[text()='Logout']");
    private final By linkAdmin = By.xpath("//span[text()='Admin']/..");
    private final By inputSearchTab = By.xpath("//input[@placeholder= 'Search']");
    private final By linkFirstSerachResult = By.xpath("//a[contains(@href,'view')]");


    public OrangeHRMHomePage clickAdminLink() {
//        DriverManager.getDriverThreadLocal().findElement(linkAddEmployee).click();
        click(linkAdmin, WaitStrategy.CLICKABLE);
        return this;
    }

    public OrangeHRMLoginPage logoutPage() {
//        DriverManager.getDriverThreadLocal().findElement(imgProfileIcon).click();
//        DriverManager.getDriverThreadLocal().findElement(linkLogout).click();
        click(imgProfileIcon, WaitStrategy.CLICKABLE);
        click(linkLogout, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();
    }

    public OrangeHRMHomePage searchTab(String textToBeEntered) {
        sendKeys(inputSearchTab, textToBeEntered, WaitStrategy.CLICKABLE);
        return this;
    }

    public String getTopSearchTabList() {
        return getInnerText(linkFirstSerachResult, WaitStrategy.VISIBLE);
    }
}
