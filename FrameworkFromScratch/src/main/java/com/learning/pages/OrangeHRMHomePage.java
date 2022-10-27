package com.learning.pages;

import com.learning.driver.DriverManager;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage {
    private final By link_addEmployee = By.xpath("//li/a[text()='Add Employee']");

    public void clickAddEmployee() {
        DriverManager.getDriverThreadLocal().findElement(link_addEmployee).click();
        //it can return other class or this class object
    }

//    public void logoutPage(){
    //it will go to login page and if we want to do any validation , we can return login page object here
//    }
}
