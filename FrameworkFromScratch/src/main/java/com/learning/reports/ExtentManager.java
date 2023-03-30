package com.learning.reports;

import com.aventstack.extentreports.ExtentTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentManager {
    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtTest() { // making it default so that these methods cant be used outside this package-- making framework more robust
        return extTest.get();
    }

    static void setExtTest(ExtentTest ext) {
        if (Objects.nonNull(ext))
            extTest.set(ext);
    }

    static void unloadExtTest() {
        extTest.remove();
    }

}
