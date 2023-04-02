package com.learning.driver;

import com.learning.exceptions.BrowserInvocationFailedException;
import com.learning.enums.ConfigProperties;
import com.learning.factories.DriverFactory;
import com.learning.util.PropertiesUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {
//    private Driver() {
//    }

    public static void init(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check browser capabilites");
            }
            DriverManager.getDriver().get(PropertiesUtil.getValue(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}
