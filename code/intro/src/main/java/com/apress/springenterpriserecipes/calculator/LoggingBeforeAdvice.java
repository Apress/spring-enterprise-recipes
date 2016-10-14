package com.apress.springenterpriserecipes.calculator;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggingBeforeAdvice implements MethodBeforeAdvice {

    private Log log = LogFactory.getLog(this.getClass());

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        log.info("The method " + method.getName() + "() begins with "
                + Arrays.toString(args));
    }
}
