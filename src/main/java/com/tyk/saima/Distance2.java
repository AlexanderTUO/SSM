package com.tyk.saima;

import java.util.Scanner;

public class Distance2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long sum = 0;
            for (int j = 0; j < n - 1; j++) {
                long count = 0;

                for (long star = a[j] +1 ; star  <= a[j+1]; star += 2) {

                    boolean flag = true;
                    if ((star & 1) == 0) {
                        flag = false;
                        break;
                    }
                    for (int i = 3; i <= Math.sqrt(star); i += 2) {
                        if (star % i == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        count++;
                    }
                }
                sum = sum+ count*(j+1)*(n-j-1);

            }
            System.out.println(sum);
        }

        sc.close();
    }
}
