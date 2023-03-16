package com.learning.util;

import com.learning.frameworkConstants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtil {

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = true)
    // in testng.xml thread count is set to 1, but here parallel is set true so test methods run parallely
    public static Object[] getData(Method m) {  //java reflection
        String testName = m.getName();

        if (list.isEmpty()) { // calls excel initialization only once
            list = ExcelUtil.getTestData(FrameworkConstants.getTestDataSheetName());
        }

        List<Map<String, String>> iterationList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("TestName").equalsIgnoreCase(testName) && list.get(i).get("Execute").equalsIgnoreCase("Yes")) {
                iterationList.add(list.get(i));
            }
        }

//        list.removeAll(iterationList); // removes executed testcases from entire list
        //not needed as remove operation takes more time for arraylist
        return iterationList.toArray();
    }
}
