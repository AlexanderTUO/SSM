package com.tyk.demo.array2List;

import java.util.*;

public class Array2ListTest {
    public static void main(String[] args) {
//        array2List();
//        list2Array();
        listOperation();
    }

    private static void array2List() {
        String[] strs = new String[]{"I", "am"};
        List list = Arrays.asList(strs);
        System.out.println("before modify");
        list.forEach(item-> System.out.println(item));
//        list.add("tyk");
        strs[0] = "he";
        System.out.println("after modify ");
        list.forEach(item-> System.out.println(item));
    }

    private static void list2Array() {
        List<String> list = new ArrayList<String>();
        list.add("I");
        list.add("am");
        list.add("tyk");
        String[] strings = new String[3];
        strings = list.toArray(strings);
    }

    private static void listOperation() {
        List<String> list = new ArrayList<String>();
        list.add("I");
        list.add("am");
        list.add("tyk");
//        for (String s : list) {
//            if ("I".equals(s)) {
//                list.remove(s);
//            }
//        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (Objects.deepEquals("I", item)) {
                iterator.remove();
            }
        }
        list.forEach(item-> System.out.println(item));
    }
}
