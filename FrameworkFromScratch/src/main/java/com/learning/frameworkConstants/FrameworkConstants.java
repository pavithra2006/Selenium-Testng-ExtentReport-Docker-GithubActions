package com.learning.frameworkConstants;

import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;

import java.util.Properties;

public final class FrameworkConstants {
    private FrameworkConstants() {

    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";

    private static final String EXTENTREPORTSFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output";

    private static String extentReportFilesPath = "";

    private static final int EXPLICITWAIT = 20;

    public static String getConfigFilePath() {
        //getter method
        return CONFIGFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getExtentReportFilesPath() throws Exception {
        if (extentReportFilesPath.isEmpty()) {
            extentReportFilesPath = getExtentReportsPath();
            return extentReportFilesPath;
        } else {
            return extentReportFilesPath;
        }
    }

    private static String getExtentReportsPath() throws Exception {
        if (PropertiesUtil.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
            return EXTENTREPORTSFOLDERPATH + "/" + System.currentTimeMillis() + "/index.html";
        else
            return EXTENTREPORTSFOLDERPATH + "/" + "index.html";
    }

}
