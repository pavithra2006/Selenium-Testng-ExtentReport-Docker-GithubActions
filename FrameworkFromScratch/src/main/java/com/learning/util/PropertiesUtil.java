package com.learning.util;

import com.learning.exceptions.PropertyFileUsageException;
import com.learning.enums.ConfigProperties;
import com.learning.framework.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertiesUtil {

    private static Properties property = new Properties();
    private static final HashMap<String, String> CONFIGMAP = new HashMap<>();

    static {
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(fis);
            property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(ConfigProperties key) {
        if(Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase())) || Objects.isNull(key)){
            throw new PropertyFileUsageException("The given property or value is not found, please check the property file. Key given: " + key);
        }
        return CONFIGMAP.get(key.toString().toLowerCase());
    }
}
