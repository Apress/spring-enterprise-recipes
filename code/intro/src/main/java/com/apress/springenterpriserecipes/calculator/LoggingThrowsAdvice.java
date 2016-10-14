package com.apress.springenterpriserecipes.calculator;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class LoggingThrowsAdvice implements ThrowsAdvice {

    private Log log = LogFactory.getLog(this.getClass());

    public void afterThrowing(Method method, Object[] args, Object target,
            IllegalArgumentException e) throws Throwable {
        log.error("Illegal argument " + Arrays.toString(args) + " for method "
                + method.getName() + "()");
    }
}
