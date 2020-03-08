package com.tyk.interview;

public class Son extends Dad {
    private String hobby;
    static {
        System.out.println("我是子类静态块！！！");
    }
    {
        System.out.println("我是子类代码块！！！");
    }

    public Son() {
        System.out.println("我是子类构造器");
    }

    public Son(String name, int age) {
        super(name, age);
        System.out.println("我是子类二参构造器");
    }


    public static void main(String[] args) {
//        Son son = new Son("tyk", 27);
        Son son = new Son();
    }
}
