package com.learning.pages;

import com.learning.driver.DriverManager;
import com.learning.enums.WaitStrategy;
import com.learning.factories.ExplicitWaitFactory;
import com.learning.frameworkConstants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
//    protected void click(By by, String waitStrategy){
//        if(waitStrategy.equalsIgnoreCase("Clickable"))
//            explicitlyWaitForElementToBeClickable(by);
//        else if(waitStrategy.equalsIgnoreCase("Present"))
//            explicitlyWaitForElementToBePresent(by);
//        DriverManager.getDriverThreadLocal().findElement(by).click();
//    }

    protected void click(By by, WaitStrategy waitStrategy) {
//        if(waitStrategy == WaitStrategy.CLICKABLE)
//            explicitlyWaitForElementToBeClickable(by);
//        else if(waitStrategy == WaitStrategy.PRESCENCE)
//            explicitlyWaitForElementToBePresent(by);
//        DriverManager.getDriverThreadLocal().findElement(by).click();
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        elm.click();
    }

    protected void sendKeys(By by, String txtToBeEntered, WaitStrategy waitStrategy) {
//        if(waitStrategy == WaitStrategy.CLICKABLE)
//            explicitlyWaitForElementToBeClickable(by);
//        else if(waitStrategy == WaitStrategy.PRESCENCE)
//            explicitlyWaitForElementToBePresent(by);
//        DriverManager.getDriverThreadLocal().findElement(by).sendKeys(txtToBeEntered);
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        elm.sendKeys(txtToBeEntered);
    }

    protected String getPageTitle() {
        return DriverManager.getDriverThreadLocal().getTitle();
    }

    // we are keeping these methods protected, since we are going to use it within the class and not outside
    //going to wait for element present/ interactable within the class
//    protected void explicitlyWaitForElementToBeClickable(By by){
//        new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
//                .until(ExpectedConditions.elementToBeClickable(by));
////        new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(10))
////                .until(ExpectedConditions.elementToBeClickable(by));
//    }
//
//    protected void explicitlyWaitForElementToBePresent(By by){
//        new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
//                .until(ExpectedConditions.presenceOfElementLocated(by));
//    }

    protected String getInnerText(By by, WaitStrategy waitStrategy) {
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return elm.getText();

    }
}
