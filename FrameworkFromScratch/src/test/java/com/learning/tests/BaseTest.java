package com.learning.tests;

import com.learning.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {
    protected BaseTest() {
    }

    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        //Object[] data is what we are sending to each test
//        System.out.println(data[0]);    //{TestName=loginLogout, UserName=Admin, Execute=Yes, SearchValue=, Browser=Chrome, Password=admin123}
        Map<String, String> map = (Map<String, String>) data[0];    //casting to map
        Driver.init(map.get("Browser"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
