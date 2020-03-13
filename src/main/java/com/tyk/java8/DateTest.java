package com.tyk.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * @Author: tyk
 * @Date: 2020/3/13 17:27
 * @Description:
 */
public class DateTest {
    public static void main(String[] args) {
        // 获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间："+localDateTime);

        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期："+localDate);
        System.out.println("年："+localDate.getYear()+",月："+localDate.getMonth()+",日："+localDate.getDayOfMonth());

        LocalDateTime localDateTime1 = localDateTime.withYear(2012).withMonth(1);
        System.out.println(localDateTime1);
    }
}
