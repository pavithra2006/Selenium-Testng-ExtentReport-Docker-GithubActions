package com.learning.driver;

import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Objects;

public final class Driver {
    private Driver() {

    }

    public static void init(String browser) {
        if (Objects.isNull(DriverManager.getDriverThreadLocal())) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
//                DesiredCapabilities dp = new DesiredCapabilities();
//                dp.setBrowserName("Chrome");
                DriverManager.setDriverThreadLocal(WebDriverManager.chromedriver().capabilities(options).create());
            } else {
                DriverManager.setDriverThreadLocal(WebDriverManager.safaridriver().create());
            }
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
