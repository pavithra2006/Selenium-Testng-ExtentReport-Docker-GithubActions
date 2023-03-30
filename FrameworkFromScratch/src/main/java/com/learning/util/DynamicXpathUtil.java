package com.learning.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DynamicXpathUtil {

    public static By getDynamicXpath(String xpath, String value) {
        return By.xpath(String.format(xpath, value));
    }

    public static By getDynamicXpath(String xpath, String value1, String value2) {
        return By.xpath(String.format(xpath, value1, value2));
    }
}
