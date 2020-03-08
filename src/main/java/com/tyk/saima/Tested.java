package com.tyk.saima;

import java.util.Scanner;
public class Tested {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = new String[6];
        String[] strings2 = new String[6];
        char[] chars=new char[1];
        int count = 0;
        for (int i = 0; i < 6; i++) {
            strings[i] = sc.next();
            int len = strings[i].length();
            chars = new char[len];
            for (int j = 0; j < len; j++) {
                chars[j]=strings[i].charAt(strings[i].length()-1-j);
            }
            strings2[i] = String.valueOf(chars);
        }
        for (int i = 5; i >= 0; i--) {
            System.out.println(strings2[i]);
        }
        sc.close();
    }
}
