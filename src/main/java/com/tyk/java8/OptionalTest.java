package com.tyk.java8;

import java.util.Optional;

/**
 * @Author: tyk
 * @Date: 2020/3/13 15:57
 * @Description:java8新特性之Optional
 */
public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest test = new OptionalTest();
        Integer var1 = null;
        Integer var2 = 10;

        // 可为null
        Optional<Integer> a = Optional.ofNullable(var1);
        // 为null的话报NullPointerException
        Optional<Integer> b = Optional.of(var2);
        System.out.println(test.sum(a,b));
     }

    public Integer sum(Optional<Integer> a,Optional<Integer> b) {
        // 是否存在
        System.out.println("第一个参数值存在："+a.isPresent());
        System.out.println("第二个参数值存在："+b.isPresent());

        // 如果值存在，则返回；否则返回默认值
        Integer value1 = a.orElse(new Integer(2));

        // 取值
        Integer value2 = b.get();
        return value1 + value2;
    }
}
