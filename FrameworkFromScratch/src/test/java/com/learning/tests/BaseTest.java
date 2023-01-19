package com.learning.tests;

import com.learning.driver.Driver;
import com.learning.reports.ExtentSpark;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {
    protected BaseTest() {
    }

    @BeforeSuite
    protected void beforeSuite() {
        ExtentSpark.initReports();
    }

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.init();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

    @AfterSuite
    protected void afterSuite() throws IOException {
        ExtentSpark.flushReport();
    }
}
