package com.learning.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager() {

    }

    public static ThreadLocal<ExtentTest> threadLocalExtTest = new ThreadLocal<>();

    public static ExtentTest getExtTestThreadLocal() {
        return threadLocalExtTest.get();
    }

    public static void setExtTestThreadLocal(ExtentTest ext) {
        threadLocalExtTest.set(ext);
    }

    public static void unloadExtTestThreadLocal() {
        threadLocalExtTest.remove();
    }

}
