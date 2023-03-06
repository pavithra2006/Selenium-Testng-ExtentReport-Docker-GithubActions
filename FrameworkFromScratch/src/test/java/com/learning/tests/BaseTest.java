package com.learning.tests;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.learning.driver.Driver;
import com.learning.reports.ExtentManager;
import com.learning.reports.ExtentSpark;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

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
