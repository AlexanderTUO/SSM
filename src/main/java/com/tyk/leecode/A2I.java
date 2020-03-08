package com.tyk.leecode;

import java.math.BigDecimal;

/**
 *
 */
public class A2I {
    public static void main(String[] args) {
        String str = "345";
        String regex = "^[0-9]*$";
        System.out.println(str.matches(regex));
        System.out.println(str.charAt(0));
        System.out.println(new BigDecimal(str.charAt(0)));
        System.out.println(new BigDecimal(3));
        for (int i = 0; i < str.length() ; i++) {

        }
    }
}
