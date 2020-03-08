package com.tyk.leecode;

public class NoRepeatedTest {
    public static void main(String[] args) {
        int number = lengthOfLongestSubstring("abcb");
        System.out.println();
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] newStr = new char[1000];
        char[] oldStr = new char[1000];
        char[] tempStr = new char[1000];
        char[] str = s.toCharArray();
        int count=0;
        for(int i=0;i<str.length;i++){
            for(int j=0;j<newStr.length;j++){
                if(str[i]==newStr[j]){
                    newStr = new char[1000];
                    newStr[0]= str[i];
                    count=0;
                }
            }
            newStr[count++]=str[i];
        }
        String result = String.valueOf(newStr);
        System.out.println("不重复的字符串为："+result);
        return count;
    }
}
