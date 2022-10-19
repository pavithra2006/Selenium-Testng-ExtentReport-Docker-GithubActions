package com.learning.driver;

import com.learning.util.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Objects;

//we dont want to extend this class and create object for it
public final class Driver {
    private Driver() {

    }
//    public class Driver {
    //non static driver cant be referenced from static context, so make driver static
    //NOTE if both are static it would work
    //if WebDriver driver static and function non static it would work
    //but if function is static and variable is not static then it wont work
//    public static WebDriver driver;
//    private static WebDriver driver; // making it private as we are going to use threadLocalDriver
    // variable is made public only then it can be accessed from test places

    public static void init() throws Exception {
        if (Objects.isNull(DriverManager.getDriverThreadLocal())) {
            // due to some reason if browser is not closed from previous session or multiple browsers opened
            //in those cases only if no browser is actually opened this block will execute
            //Objects is from java or we can also use driver == null / driver != null
//            driver = WebDriverManager.chromedriver().create();
            //intial value of thread local variable is null
            DriverManager.setDriverThreadLocal(WebDriverManager.chromedriver().create());
//            driver.get("https://google.com/");
//            driver.manage().window().maximize();
//            DriverManager.getDriverThreadLocal().get(ReadPropertyFile.getValue("URL"));
            DriverManager.getDriverThreadLocal().get(ReadPropertyFile.getValue("url"));
            DriverManager.getDriverThreadLocal().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        //due to some reason if browser already quitted, then if we again do driver.quit() it will throw error - noSuchSessionException
        //to handle that check for non null
        if (Objects.nonNull(DriverManager.getDriverThreadLocal())) {
//            driver.quit();
//            driver = null; // automatically driver is not setting to null so keeping it to null
            DriverManager.getDriverThreadLocal().quit();
            DriverManager.unloadDriverThreadLocal();
//            driver = null; // instead of setting it to null we can use remove method
        }
    }
}
