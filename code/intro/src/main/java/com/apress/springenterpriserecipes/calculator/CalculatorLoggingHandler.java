package com.apress.springenterpriserecipes.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CalculatorLoggingHandler implements InvocationHandler {

    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CalculatorLoggingHandler(target));
    }

    private Log log = LogFactory.getLog(this.getClass());

    private Object target;

    public CalculatorLoggingHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // Log the method beginning with the method name and arguments.
        log.info("The method " + method.getName() + "() begins with "
                + Arrays.toString(args));

        // Perform the actual calculation on the target calculator object by calling
        // Method.invoke() and passing in the target object and method arguments.
        Object result = method.invoke(target, args);

        // Log the method ending with the returning result.
        log.info("The method " + method.getName() + "() ends with " + result);
        return result;
    }
}
