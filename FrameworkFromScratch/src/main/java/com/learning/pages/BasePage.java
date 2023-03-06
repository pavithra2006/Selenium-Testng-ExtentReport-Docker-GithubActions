package com.learning.pages;

import com.learning.driver.DriverManager;
import com.learning.enums.WaitStrategy;
import com.learning.factories.ExplicitWaitFactory;
import com.learning.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elmName) {
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        elm.click();
        ExtentLogger.pass(elmName + " button is clicked");
    }

    protected void sendKeys(By by, String txtToBeEntered, WaitStrategy waitStrategy, String elmName) {
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        elm.sendKeys(txtToBeEntered);
        ExtentLogger.pass("Value is set on " + elmName + " text box field");
    }

    protected String getPageTitle() {
        return DriverManager.getDriverThreadLocal().getTitle();
    }

    protected String getInnerText(By by, WaitStrategy waitStrategy) {
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return elm.getText();
    }
}
