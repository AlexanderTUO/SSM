package com.tyk.saima;

import java.math.BigDecimal;
import java.util.Scanner;
public class SumTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lines = new String[1000];
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] arrays = str.trim().split(" ");
            double num = Integer.parseInt(arrays[0]);
            int count = Integer.parseInt(arrays[1]);
            double sum=0;
            for (int i = 0; i < count; i++) {
                sum += num;
                num = Math.sqrt(num);
            }
            BigDecimal sum_dec = new BigDecimal(sum);
            sum = sum_dec.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(sum);
        }

        scanner.close();
    }
}
