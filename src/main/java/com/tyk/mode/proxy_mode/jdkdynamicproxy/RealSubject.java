package com.tyk.mode.proxy_mode.jdkdynamicproxy;

import com.tyk.annotation.CustomTransactional;
import org.springframework.transaction.annotation.Transactional;

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
