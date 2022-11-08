package com.learning.driver;

import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Objects;

public final class Driver {
    private Driver() {

    }

    public static void init() throws Exception {
        if (Objects.isNull(DriverManager.getDriverThreadLocal())) {
            DriverManager.setDriverThreadLocal(WebDriverManager.chromedriver().create());
//            DriverManager.getDriverThreadLocal().get(PropertiesUtil.getValue("url"));
            DriverManager.getDriverThreadLocal().get(PropertiesUtil.getValue(ConfigProperties.URL));
            DriverManager.getDriverThreadLocal().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriverThreadLocal())) {
            DriverManager.getDriverThreadLocal().quit();
            DriverManager.unloadDriverThreadLocal();
        }
    }
}
