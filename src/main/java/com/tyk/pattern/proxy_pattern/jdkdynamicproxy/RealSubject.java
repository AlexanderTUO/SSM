package com.tyk.pattern.proxy_pattern.jdkdynamicproxy;

import com.tyk.annotation.CustomTransactional;

public class RealSubject implements Subject{
    @Override
    @CustomTransactional(id=1,propagation = "REQUIRED")
    public void doSomething() {
        System.out.println("RealSubject do something ！！！");
        doSomething2();
    }

    @Override
    @CustomTransactional(id=1,propagation = "REQUIRED")
    public void doSomething2() {
        System.out.println("RealSubject also do something ！！！");
    }
}
