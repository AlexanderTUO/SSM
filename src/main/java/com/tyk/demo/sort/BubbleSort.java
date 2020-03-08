package com.tyk.demo.sort;

public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort();
    }

    public static void bubbleSort() {
        int[] array = new int[]{1, 6, 2, 8, 4, 9, 7};
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
     }
}
