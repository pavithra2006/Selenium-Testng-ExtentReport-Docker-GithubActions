package com.learning.util;

import org.openqa.selenium.By;

public final class DynamicXpathUtil {
    private DynamicXpathUtil() {

    }

    public static By getDynamicXpath(String xpath, String value) {
        return By.xpath(String.format(xpath, value));
    }

    public static By getDynamicXpath(String xpath, String value1, String value2) {
        return By.xpath(String.format(xpath, value1, value2));
    }
}
