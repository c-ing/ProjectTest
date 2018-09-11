package com.java.design_model.cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by cdc on 2018/4/10.
 */
public class WelcomeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before:" + method.getName());
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("after:" + method.getName());
        return object;
    }
}
