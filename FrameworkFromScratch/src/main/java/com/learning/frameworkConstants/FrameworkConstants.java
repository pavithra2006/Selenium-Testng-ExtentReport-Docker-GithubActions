package com.learning.frameworkConstants;

public final class FrameworkConstants {
    private FrameworkConstants() {

    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    //    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";

    private static final int EXPLICITWAIT = 20;

    public static String getConfigFilePath() {
        //getter method
        return CONFIGFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

}
