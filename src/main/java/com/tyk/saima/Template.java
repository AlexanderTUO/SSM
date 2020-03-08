package com.tyk.saima;

import java.util.Scanner;

public class Template {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int score  = a+b+c+d;
            if(a>=60&&b>=60&&c>=90&&d>=90&&score>=310){
                if(score>=350)
                    System.out.println("Gongfei");
                else
                    System.out.println("Zifei");
            }else{
                System.out.println("Fail");
            }
        }
    }
}
