package com.learning.tests;

import com.learning.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

//extend base test in all page tests
//industry standard is setUp and tearDown() method names

public class BaseTest {
    //no need of using private class because we need to extend it to other pageTests

    protected BaseTest() {
        //prevents us from creating object for this BaseTest class in other classes but still needs to be visible to other classes
    }

    //private, protected, default, last is public
    @BeforeMethod
//    public void setUp() {
    protected void setUp() throws Exception {
        //needs to be used in other test classes
        Driver.init();
    }

    @AfterMethod
    protected void tearDown() {
//        public void tearDown() {
        //for each testng test this step will trigger
        Driver.quitDriver();
    }
}
