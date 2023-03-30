package com.learning.listeners;

import com.learning.annotation.FrameworkAnnotation;
import com.learning.reports.ExtentLogger;
import com.learning.reports.ExtentSpark;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {  // ISuiteListener
        ExtentSpark.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentSpark.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {   //ITestListener
        ExtentSpark.createTest(result.getMethod().getDescription());
        ExtentSpark.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentSpark.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " Testcase passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " Testcase failed", true);
        ExtentLogger.fail(result.getThrowable().toString());    // gives first line in error message
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); //get stack trace returns array, so convert to string
        // returns entire error stack trace
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " Testcase skipped");
    }

}
