package com.learning.pages;

import com.learning.enums.WaitStrategy;
import com.learning.util.DynamicXpathUtil;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {
    private final By imgProfileIcon = By.xpath("//span[@class='oxd-userdropdown-tab']/img");
    private final By linkLogout = By.xpath("//a[text()='Logout']");
    private final By linkAdmin = By.xpath("//span[text()='Admin']/..");
    private final By inputSearchTab = By.xpath("//input[@placeholder= 'Search']");
    private final By linkFirstSerachResult = By.xpath("//a[contains(@href,'view')]");

    private static final String SIDE_MENU_LINK = "//span[text()='%s']/..";

    public OrangeHRMHomePage clickAdminLink() {
        click(linkAdmin, WaitStrategy.CLICKABLE, "Admin Link");
        return this;
    }

    public OrangeHRMLoginPage logoutPage() {
        click(imgProfileIcon, WaitStrategy.CLICKABLE, "Image profile icon");
        click(linkLogout, WaitStrategy.CLICKABLE, "Logout link");
        return new OrangeHRMLoginPage();
    }

    public OrangeHRMHomePage searchTab(String textToBeEntered) {
        sendKeys(inputSearchTab, textToBeEntered, WaitStrategy.CLICKABLE, " InputSearchTab");
        return this;
    }

    public String getTopSearchTabList() {
        return getInnerText(linkFirstSerachResult, WaitStrategy.VISIBLE);
    }

    public boolean verifySideBardMenu(String menuList) {
        String[] menu = menuList.split(";");
        boolean isPresent = true;

        for (String s : menu) {
            if (!isElementDisplayed(DynamicXpathUtil.getDynamicXpath(SIDE_MENU_LINK, s.trim()), WaitStrategy.PRESCENCE, s)) {
                isPresent = false;
                break;
            }
        }

        return isPresent;

    }
}
