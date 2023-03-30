package com.learning.util;

import com.learning.driver.DriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenshotUtil {

    public static String getBase64Img() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
