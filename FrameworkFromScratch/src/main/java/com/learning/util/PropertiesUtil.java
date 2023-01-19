package com.learning.util;

import com.learning.enums.ConfigProperties;
import com.learning.frameworkConstants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesUtil {

    private PropertiesUtil() {

    }

    private static Properties property = new Properties();
    private static final HashMap<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(fis);
            property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(ConfigProperties key) throws Exception {
        if (Objects.isNull(key.toString().toLowerCase()) || Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase()))) {
            throw new Exception("The given property or value is not found, please check the property file. Key given: " + key);
        }
        return CONFIGMAP.get(key.toString().toLowerCase());
    }
}
