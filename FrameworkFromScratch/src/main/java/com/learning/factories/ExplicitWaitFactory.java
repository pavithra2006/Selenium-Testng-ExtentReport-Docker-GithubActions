package com.learning.factories;

import com.learning.driver.DriverManager;
import com.learning.enums.WaitStrategy;
import com.learning.framework.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExplicitWaitFactory {

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
        WebElement elm = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            elm = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESCENCE) {
            elm = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            elm = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            elm = DriverManager.getDriver().findElement(by);
        }
        return elm;
    }
}

