package com.learning.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;
import com.learning.util.ScreenshotUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentLogger {
    public static void pass(String message) {
        ExtentManager.getExtTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertiesUtil.getValue(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getExtTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Img()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        if (PropertiesUtil.getValue(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getExtTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Img()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertiesUtil.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getExtTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Img()).build());
        } else {
            skip(message);
        }
    }
}
