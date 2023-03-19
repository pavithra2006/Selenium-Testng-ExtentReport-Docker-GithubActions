package com.learning.driver;

import org.openqa.selenium.WebDriver;

//keep it final as we need not inherit for this class and create private constructor as we need not crate obj for this
public final class DriverManager {
    private DriverManager() {

    }

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driverReference) {
        threadLocalDriver.set(driverReference);
    }

    public static void unloadDriver() {
        threadLocalDriver.remove();
    }
}
