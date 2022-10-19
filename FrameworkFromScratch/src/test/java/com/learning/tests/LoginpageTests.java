package com.learning.tests;

import com.learning.driver.Driver;
import com.learning.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

//Here each page test should extend BaseTest
//public class LoginpageTests extends BaseTest{ --> keep pageTests final because so that we will not be able to extended/ inherited it to other classes
public final class LoginpageTests extends BaseTest {
    //create private constructor so that for the pageTest so that we cant create object for it in other classes( because it is private)
    //NOTE: we can still create object for this class in this page itself
    private LoginpageTests() {

    }

    @Test
    public void test1() {
        DriverManager.getDriverThreadLocal().findElement(By.xpath("//input[@name = 'q']")).sendKeys("test1", Keys.ENTER);
    }

//    @Test
//    public void test2() {
//        DriverManager.getDriverThreadLocal().findElement(By.xpath("//input[@name = 'q']")).sendKeys("test2", Keys.ENTER);
//    }
}
