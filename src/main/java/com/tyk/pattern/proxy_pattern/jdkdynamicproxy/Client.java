package com.tyk.pattern.proxy_pattern.jdkdynamicproxy;

public class Client {
    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = new JDKDynamicProxy((new RealSubject())).getProxy();
        subject.doSomething();
//        subject.doSomething2();
    }
}
