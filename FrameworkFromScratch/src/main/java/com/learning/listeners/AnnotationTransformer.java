package com.learning.listeners;


import com.learning.util.DataProviderUtil;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    //we need to mention Iannotationtransformer, ITestLister, ISuiteLister and IMethodInterceptor in testng.xml file
    @Override
    public void transform(ITestAnnotation annotation, Class testclass, Constructor testconstructor, Method testMethod) {
        annotation.setDataProvider("getData");  // no need of mentioning parameters in test file as @Test()
        annotation.setDataProviderClass(DataProviderUtil.class);

        annotation.setRetryAnalyzer(RetryFailedTestcases.class);

    }
}
