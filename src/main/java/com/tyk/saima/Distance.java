package com.tyk.saima;

import java.util.Scanner;
public class Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] num = new int[count];
        for (int i = 0; i < count; i++) {
            num[i] = scanner.nextInt();
        }
        int distance = 0;
        for (int i = 0; i < count-1; i++) {
            for (int j = i+1; j < count; j++) {
                distance += getDistance(num[i], num[j]);
            }
        }
        System.out.println(distance);
        scanner.close();
    }


    public static int getDistance(int num1, int num2) {
        int distance = 0;
        boolean flag;
        int num = num1 + 1;
        while (num > num1 && num < num2) {
            flag = true;
            for (int j = 2; j < Math.sqrt(num); j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                distance++;
            }
            num++;
            if (num == num2) {
                break;
            }
        }
        return distance;
    }
}
