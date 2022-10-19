package com.learning.util;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
    private ReadPropertyFile() {

    }

    public static String getValue(String key) throws Exception {
        String value = "";
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
        property.load(fis);
        value = property.getProperty(key);
        if (Objects.isNull(value)) {
            throw new Exception("The given proprety value " + key + " is not found, please check the property file");
        }
        return value;
    }
}
