package com.learning.driver;

import com.learning.Exceptions.BrowserInvocationFailedException;
import com.learning.enums.ConfigProperties;
import com.learning.factories.DriverFactory;
import com.learning.util.PropertiesUtil;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {
    private Driver() {

    }

    public static void init(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {

//            if (browser.equalsIgnoreCase("chrome")) {
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--remote-allow-origins=*");
//                DriverManager.setDriverThreadLocal(WebDriverManager.chromedriver().capabilities(options).create());
//            } else {
//                DriverManager.setDriverThreadLocal(WebDriverManager.safaridriver().create());
//            }
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
