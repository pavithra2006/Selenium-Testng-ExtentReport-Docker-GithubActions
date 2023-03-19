package com.learning.factories;

import com.learning.driver.DriverManager;
import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {
    private DriverFactory() {

    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;
        String runmode = PropertiesUtil.getValue(ConfigProperties.REMOTE);

        if (browser.equalsIgnoreCase("Chrome")) {
            if (runmode.equalsIgnoreCase("yes")) {
//                DesiredCapabilities cap = new DesiredCapabilities();
//                cap.setBrowserName(Browser.CHROME.browserName());

                ChromeOptions opt = new ChromeOptions();
                opt.setCapability("browserName", Browser.CHROME);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);

            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = WebDriverManager.chromedriver().capabilities(options).create();
                //sometimes there might be some issue in browser invocation here aswell, so throw exception commonly in init() method
            }
        } else {
            // safari logic
        }

        return driver;
    }
}
