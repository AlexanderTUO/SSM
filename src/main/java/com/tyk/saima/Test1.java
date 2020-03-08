package com.tyk.saima;

import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] arrays = new String[count];
        for (int i = 0; i < count; i++) {
            arrays[i] = scanner.next();
        }
        int numCount;
        for (int i = 0; i < count; i++) {
            String str = arrays[i];
            numCount = 0;
            for (int j = 0; j < str.length()-1; j++) {
                for (int k = 1; k < str.length(); k++) {
                    if (str.charAt(j) == str.charAt(k)) {
                        numCount++;
                    }else {
                        j=k;
                    }
                }
            }
            System.out.println(numCount);
        }
        scanner.close();
    }
}
