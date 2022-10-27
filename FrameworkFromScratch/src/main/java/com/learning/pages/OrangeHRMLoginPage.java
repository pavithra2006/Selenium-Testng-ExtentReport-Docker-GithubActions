package com.learning.pages;

import com.learning.driver.DriverManager;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage {
    // no need of extending the page class
    // no need of private constructor , as we need to create object for this in the test class

    /*
    id
    name
    classname
    linktext
    partial link text
    css or xpath
     */

    //using escape sequence for " in xpath - use \before each double quotes
    private final By textbox_username = By.xpath("//input[@name=\"username\"]");
    //validate if type is password- whether dot is shown
    private final By textbox_password = By.xpath("//input[@name='password' and @type='password']");
    private final By button_login = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username) {
        DriverManager.getDriverThreadLocal().findElement(textbox_username).sendKeys(username);
//         anonymous object // method chaining - using the anonymous obejct we can access all the other methods supported by this class
//        return new OrangeHRMLoginPage();
//         instead of this use simple this () keyword- returns current class object
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        DriverManager.getDriverThreadLocal().findElement(textbox_password).sendKeys(password);
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
//  public void clickLogin() {
        DriverManager.getDriverThreadLocal().findElement(button_login).click();
        //return next page object
        return new OrangeHRMHomePage();
    }
}
