package com.apress.springenterpriserecipes.calculator;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class LoggingAfterAdvice implements AfterReturningAdvice {

    private Log log = LogFactory.getLog(this.getClass());

    public void afterReturning(Object returnValue, Method method,
            Object[] args, Object target) throws Throwable {
        log.info("The method " + method.getName() + "() ends with "
                + returnValue);
    }
}
