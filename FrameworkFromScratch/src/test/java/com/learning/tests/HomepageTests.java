package com.learning.tests;

import com.learning.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomepageTests extends BaseTest {
    private HomepageTests() {

    }

    @Test
    public void test3() {
        DriverManager.getDriverThreadLocal().findElement(By.xpath("//input[@name = 'q']")).sendKeys("test3", Keys.ENTER);
    }
}
