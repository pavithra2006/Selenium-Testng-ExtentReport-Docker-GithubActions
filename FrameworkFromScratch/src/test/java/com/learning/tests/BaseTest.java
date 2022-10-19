package com.learning.tests;

import com.learning.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected BaseTest() {
    }
    
    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.init();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
