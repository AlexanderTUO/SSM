package com.tyk.pattern.proxy_pattern.cglibdynamicproxy;

public class HelloService {
    public HelloService() {
        System.out.println("我是构造器");
    }

//    @CustomTransactional(id=1,description = "transactional")
    public void sayHello() {
        System.out.println("hello,I'm tyk");
        sayHi();
    }

    // final修饰不会被代理，因为代理类时通过继承的方式
     public void sayHi() {
        System.out.println("Hi,idiot");
    }
}
