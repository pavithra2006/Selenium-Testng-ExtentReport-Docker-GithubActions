package com.learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learning.enums.CategoryType;
import com.learning.framework.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentSpark { // no need to extend it
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

        String isRemote = System.getProperty("isRemote", "no");

        if (!isRemote.equalsIgnoreCase("yes")) {
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilesPath()).toURI());
                //note here we can use try catch itself, say after flushing report we need to disconnect from db
                //in this case if we use System.exit(0); then db connection would not be successfully removed
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createTest(String testCaseName) {
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
