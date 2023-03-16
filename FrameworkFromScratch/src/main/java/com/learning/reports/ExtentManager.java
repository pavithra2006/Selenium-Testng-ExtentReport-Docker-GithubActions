package com.learning.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager() {

    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtTest() { // making it default so that these methods cant be used outside this package-- making framework more robust
        return extTest.get();
    }

    static void setExtTest(ExtentTest ext) {
        extTest.set(ext);
    }

    static void unloadExtTest() {
        extTest.remove();
    }

}
