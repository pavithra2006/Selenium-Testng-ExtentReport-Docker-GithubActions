package com.learning.listeners;

import com.learning.enums.ConfigProperties;
import com.learning.util.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public final class RetryFailedTestcases implements IRetryAnalyzer {
    //generally if there are 1000test and 200 fails, if we rerun some 10 passes
    //It takes more time to figure why 200 failed at first run and 10 passed in retry
    //So better we can avoid using retry mechanism
    private int count = 0;
    private int maxRetries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if (PropertiesUtil.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            value = count < maxRetries;
            count++;
        }
        return value;
    }
}
