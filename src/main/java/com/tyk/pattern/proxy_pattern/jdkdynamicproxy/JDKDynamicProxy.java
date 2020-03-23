package com.tyk.pattern.proxy_pattern.jdkdynamicproxy;

import com.tyk.annotation.CustomTransactional;
import com.tyk.util.TransactionalUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

public class JDKDynamicProxy implements InvocationHandler {
    private Object target;
    private TransactionalUtils transactionalUtils = new TransactionalUtils();

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before");
        CustomTransactional ct = method.getAnnotation(CustomTransactional.class);
        Object result=null;

        if (ct != null && Objects.equals("REQUIRED", ct.propagation())) {
//            TransactionStatus transactionStatus = null;
            try {
                System.out.println("开启事务");
//                transactionStatus = transactionalUtils.begin();

                result = method.invoke(target, args);

                System.out.println("提交事务");
//                transactionalUtils.commit(transactionStatus);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
//                if (transactionStatus == null) {
//                    transactionalUtils.rollBack(transactionStatus);
//                }
            }
        }else {
            result = method.invoke(target, args);
        }
        System.out.println("do something after");
        return result;
    }
}
