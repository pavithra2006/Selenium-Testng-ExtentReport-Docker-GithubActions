package com.learning.tests;

import com.learning.driver.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginpageTests extends BaseTest {
    private LoginpageTests() {

    }

    @Test
    public void test1() {
        DriverManager.getDriver().findElement(By.xpath("//input[@name = 'q']")).sendKeys("test1", Keys.ENTER);
    }

    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.xpath("//input[@name = 'q']")).sendKeys("test2", Keys.ENTER);
    }
}
