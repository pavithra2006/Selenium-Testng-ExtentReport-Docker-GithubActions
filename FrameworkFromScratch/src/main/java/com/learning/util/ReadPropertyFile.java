package com.learning.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile() {

    }

    public static String getValue(String key) throws Exception {
        String value = "";
        Properties property = new Properties();
//        System.out.println(System.getProperty("user.dir")); //Users/pavithra/Desktop/EndToEndTestingFramework/FrameworkFromScratch
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
        property.load(fis);
//        value = property.getProperty("key");
        value = property.getProperty(key);
//        if (value == null) {
        if (Objects.isNull(value)) {
            //previously it was throwing null pointer exception
            throw new Exception("The given proprety value " + key + " is not found, please check the property file");
        }
        return value;
    }
}
