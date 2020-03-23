package com.tyk.pattern.proxy_pattern.cglibdynamicproxy;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\Project\\code");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloService proxy = (HelloService) enhancer.create();
        proxy.sayHello();
//        proxy.sayHi();
    }
}
