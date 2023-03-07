package com.learning.listeners;

import com.learning.reports.ExtentLogger;
import com.learning.reports.ExtentSpark;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {
    public void onStart(ISuite suite) {  // ISuiteListener
        try {
            ExtentSpark.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onFinish(ISuite suite) {
        try {
            ExtentSpark.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestStart(ITestResult result) {   //ITestListener
        ExtentSpark.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " Testcase passed");
    }

    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " Testcase failed", true);
            ExtentLogger.fail(result.getThrowable().toString());    // gives first line in error message
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); //get stack trace returns array, so convert to string
            // returns entire error stack trace
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " Testcase skipped");
    }

}
