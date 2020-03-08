package com.tyk.interview;

public class Dad {
    private String name;
    private int age;
    static Son son = new Son();
    static {
        System.out.println("我是父类静态块！！！");
    }
    {
        System.out.println("我是父类代码块！！！");
    }

    public Dad() {
        System.out.println("我是父类构造器！！！");
    }

    public Dad(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("我是父类二参构造器！！！");
    }
}
