package com.tyk.demo.stringdemo;

public class splitTest {
    public static void main(String[] args) {
        String str = new String("a,b,c,,");
        String[] array = str.split(",");
        System.out.println(array.length);
    }
}
