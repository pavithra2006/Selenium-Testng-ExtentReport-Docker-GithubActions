package com.learning.factories;

import com.learning.driver.DriverManager;
import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
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
                ChromeOptions opt = new ChromeOptions();
                opt.setCapability("BrowserName", Browser.CHROME);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), opt);

            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = WebDriverManager.chromedriver().capabilities(options).create();
                //sometimes there might be some issue in browser invocation here aswell, so throw exception commonly in init() method
            }
        } else {//edge
            if (runmode.equalsIgnoreCase("yes")) {
                EdgeOptions opt = new EdgeOptions();
                opt.setCapability("BrowserName", Browser.EDGE);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), opt);

            } else {
                driver = WebDriverManager.edgedriver().create();
            }

        }

        return driver;
    }
}
