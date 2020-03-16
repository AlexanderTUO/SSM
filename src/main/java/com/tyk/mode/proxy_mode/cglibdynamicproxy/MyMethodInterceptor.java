package com.tyk.mode.proxy_mode.cglibdynamicproxy;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    /**
     *
     * @param o 被代理对象
     * @param method 被代理的方法
     * @param objects 方法的参数
     * @param methodProxy 触发父类方法的对象
     * @return 方法返回的对象
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置增强");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("后置增强");
        return result;
    }
}
