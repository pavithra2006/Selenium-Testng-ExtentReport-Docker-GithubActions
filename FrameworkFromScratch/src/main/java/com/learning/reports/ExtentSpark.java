package com.learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learning.enums.CategoryType;
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

    public static void initReports() {
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

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unloadExtTest();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilesPath()).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTest(String testCaseName) {
//        ExtentTest test = extent.createTest(testCaseName);
//        ExtentManager.setExtTestThreadLocal(test);

        ExtentManager.setExtTest(extent.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors) {
        for (String author : authors) {
            ExtentManager.getExtTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentManager.getExtTest().assignCategory(category.toString());
        }
    }
}
