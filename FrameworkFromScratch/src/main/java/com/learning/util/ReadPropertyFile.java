package com.learning.util;

import com.learning.frameworkConstants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
    private ReadPropertyFile() {

    }

    private static Properties property = new Properties();
    private static final HashMap<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
            property.load(fis);
            //if a value is having space then it would cause issue, so better trim() value
//            property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
            property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            throw new Exception("The given property or value is not found, please check the property file. Key given: " + key);
        }
        return CONFIGMAP.get(key);
    }
}
