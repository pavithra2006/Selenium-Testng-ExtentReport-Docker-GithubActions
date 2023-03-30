package com.learning.framework.constants;

import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConstants {
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";

    private static final String EXCELFILEPATH = RESOURCESPATH + "/excel/TestDataIMethodInterceptor.xlsx";

    private static final String EXTENTREPORTSFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output";

    private static String extentReportFilesPath = "";

    private static final int EXPLICITWAIT = 20;

    private static final String RUNMANAGERSHEETNAME = "RUN MANAGER";
    private static final String TESTDATASHEETNAME = "TEST DATA";

    public static String getRunManagerSheetName() {
        return RUNMANAGERSHEETNAME;
    }

    public static String getTestDataSheetName() {
        return TESTDATASHEETNAME;
    }

    public static String getConfigFilePath() {
        //getter method
        return CONFIGFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getExtentReportFilesPath() {
        if (extentReportFilesPath.isEmpty()) {
            extentReportFilesPath = getExtentReportsPath();
            return extentReportFilesPath;
        } else {
            return extentReportFilesPath;
        }
    }

    private static String getExtentReportsPath() {
        if (PropertiesUtil.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
            return EXTENTREPORTSFOLDERPATH + "/" + System.currentTimeMillis() + "/index.html";
        else
            return EXTENTREPORTSFOLDERPATH + "/" + "index.html";
    }

    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }

}
