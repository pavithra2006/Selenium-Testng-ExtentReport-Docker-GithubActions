package com.learning.frameworkConstants;

public final class FrameworkConstants {
    private FrameworkConstants() {

    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    //    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";

    public static String getConfigFilePath() {
        //getter method
        return CONFIGFILEPATH;
    }

}
