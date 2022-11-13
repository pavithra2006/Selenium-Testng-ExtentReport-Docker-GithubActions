package com.learning.factories;

import com.learning.driver.DriverManager;
import com.learning.enums.WaitStrategy;
import com.learning.frameworkConstants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {
    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
        WebElement elm = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            elm = new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESCENCE) {
//            explicitlyWaitForElementToBePresent(by);
            elm = new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            elm = new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            elm = DriverManager.getDriverThreadLocal().findElement(by);
        }
        return elm;
    }
}

