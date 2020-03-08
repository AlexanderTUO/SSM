package com.tyk.config;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        double f = 31.5585;
        double f1 = 111231.5585;
        BigDecimal bigDecimal1 = new BigDecimal(2);
        BigDecimal bigDecimal2= new BigDecimal(3);
        BigDecimal bigDecimal3 = bigDecimal1.divide(bigDecimal2,4,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal3);
    }
}
