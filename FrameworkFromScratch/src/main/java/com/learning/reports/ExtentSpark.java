package com.learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learning.frameworkConstants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public final class ExtentSpark { // no need to extend it

    //no need to create obj

    private ExtentSpark() {

    }

    private static ExtentReports extent;

//    public static ExtentTest test; // causes thread local issue

    public static void initReports() throws Exception {
        if (Objects.isNull(extent)) { // if we call this method twice null check avoids the problem
            extent = new ExtentReports(); // object for extent report
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilesPath());
            //gets generated in root folder // obj for extent spark reporter class
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation test report");      // tab name
            spark.config().setReportName("Extent1 spark report"); // found in top right side
            extent.attachReporter(spark);
        }
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }

        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilesPath()).toURI());
    }

    public static void createTest(String testCaseName) {
//        ExtentTest test = extent.createTest(testCaseName);
//        ExtentManager.setExtTestThreadLocal(test);

        ExtentManager.setExtTest(extent.createTest(testCaseName));
    }
}
