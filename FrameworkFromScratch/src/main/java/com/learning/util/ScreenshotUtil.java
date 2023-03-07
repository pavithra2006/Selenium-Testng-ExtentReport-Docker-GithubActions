package com.learning.util;

import com.learning.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtil {
    private ScreenshotUtil() {

    }

    public static String getBase64Img() {
        return ((TakesScreenshot) DriverManager.getDriverThreadLocal()).getScreenshotAs(OutputType.BASE64);
    }
}
