package com.learning.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

//keep it final as we need not inherit for this class and create private constructor as we need not crate obj for this
public final class DriverManager {
    private DriverManager() {

    }

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    //used in same package, so keeping it to default
    static void setDriver(WebDriver driverReference) {
        // we should not pass null to set, as it might cause some memory leak
        if (Objects.nonNull(driverReference))
            threadLocalDriver.set(driverReference);
    }

    static void unloadDriver() {
        threadLocalDriver.remove();
    }
}
