package com.tyk.saima;

import java.util.Scanner;

/**
 * beginIndex -- 起始索引（包括）, 索引从 0 开始。
 *
 * endIndex -- 结束索引（不包括）
 */
public class Moslems {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            int len = input.length();
            int i = 0, j = len -1;
            int end = j;
            while (i <= j) {
                if (input.charAt(i) == input.charAt(j)) {
                    i++;
                    j--;
                }else {
                    i = 0;
                    j--;
                    end = j;
                }
            }
            System.out.println(end +1);
        }
        in.close();
    }
}
