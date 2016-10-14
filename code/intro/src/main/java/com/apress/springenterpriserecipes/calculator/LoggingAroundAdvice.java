package com.apress.springenterpriserecipes.calculator;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingAroundAdvice implements MethodInterceptor {

    private Log log = LogFactory.getLog(this.getClass());

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        log.info("The method " + methodInvocation.getMethod().getName()
                + "() begins with "
                + Arrays.toString(methodInvocation.getArguments()));
        try {
            Object result = methodInvocation.proceed();
            log.info("The method " + methodInvocation.getMethod().getName()
                    + "() ends with " + result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument "
                    + Arrays.toString(methodInvocation.getArguments())
                    + " for method " + methodInvocation.getMethod().getName()
                    + "()");
            throw e;
        }
    }
}
