package com.learning.tests;

import com.learning.driver.Driver;
import com.learning.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

//Here each page test should extend BaseTest

public final class HomepageTests extends BaseTest {
    HomepageTests() {

    }

    @Test
    public void test3() {
        //use getThreadlocalDriver everywhere
//        Driver.driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys("test3", Keys.ENTER);
        DriverManager.getDriverThreadLocal().findElement(By.xpath("//input[@name = 'q']")).sendKeys("test3", Keys.ENTER);
    }
}
