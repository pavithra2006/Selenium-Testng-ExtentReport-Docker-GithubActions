package com.learning.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Driver {
    //non static driver cant be referenced from static context, so make driver static
    //NOTE if both are static it would work
    //if WebDriver driver static and function non static it would work
    //but if function is static and variable is not static then it wont work
    public static WebDriver driver;
    // varibale is made public only then it can be accessed from test places

    public static void init() {
        if (Objects.isNull(driver)) {
            // due to some reason if browser is not closed from previous session or multiple browsers opened
            //in those cases only if no browser is actually opened this block will execute
            //Objects is from java or we can also use driver == null / driver != null
            driver = WebDriverManager.chromedriver().create();
            driver.get("https://google.com/");
        }
    }

    public static void quitDriver() {
        //due to some reason if browser already quitted, then if we again do driver.quit() it will throw error - noSuchSessionException
        //to handle that check for non null
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null; // automatically driver is not setting to null so keeping it to null
        }
    }
}
