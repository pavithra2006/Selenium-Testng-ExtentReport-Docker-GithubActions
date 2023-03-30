package com.learning.listeners;

import com.learning.framework.constants.FrameworkConstants;
import com.learning.util.ExcelUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        List<Map<String, String>> list = ExcelUtil.getTestData(FrameworkConstants.getRunManagerSheetName());
        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i < methods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestName")) &&
                        list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
                    methods.get(i).getMethod().setDescription(list.get(j).get("TestDescription"));
//                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
//                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));

                    result.add(methods.get(i));
                }
            }
        }

        return result;
    }
}
