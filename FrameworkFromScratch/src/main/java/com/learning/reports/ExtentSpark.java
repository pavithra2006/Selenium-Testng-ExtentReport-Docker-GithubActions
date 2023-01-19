package com.learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public final class ExtentSpark { // no need to extend it

    //no need to create obj

    private ExtentSpark() {

    }

    private static ExtentReports extent;

    public static ExtentTest test;

    public static void initReports() {
        if (Objects.isNull(extent)) { // if we call this method twice null check avoids the problem
            extent = new ExtentReports(); // object for extent report
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "index.html");
            //gets generated in root folder // obj for extent spark reporter class
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation test report");      // tab name
            spark.config().setReportName("Extent1 spark report"); // found in top right side
            extent.attachReporter(spark);
        }
    }

    public static void flushReport() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "index.html").toURI());
    }

    public static void createTest(String testCaseName) {
        test = extent.createTest(testCaseName);
    }
}
