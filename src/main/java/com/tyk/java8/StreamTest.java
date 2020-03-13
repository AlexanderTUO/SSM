package com.tyk.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: tyk
 * @Date: 2020/3/13 16:15
 * @Description: java8新特性之Stream
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("I", "am", "", "tyk","hello","world","!!!");
        // 生成流,filter,Collectors
        List<String> filtered = list.stream().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        List<String> filtered2 = list.parallelStream().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        String joiningStr = list.stream().filter(item -> !item.isEmpty()).collect(Collectors.joining(","));

        // forEach
        System.out.println("原始List：");
        list.forEach(System.out::println);
        System.out.println("stream流，空过滤后：");
        filtered.forEach(System.out::println);
        System.out.println("parallelStream流，空过滤后：");
        filtered2.forEach(System.out::println);
        System.out.println("不过滤parallelStream：");
        filtered2.parallelStream().forEach(System.out::println);
        System.out.println("joiningStr:"+joiningStr);
        // filter
        long count = list.stream().filter(item -> !item.isEmpty()).count();
        System.out.println("不为空元素的数量为："+count);

        // limit,sorted
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        // 统计
        List<Integer> numbers = Arrays.asList(4, 56, 97, 1, 4, 69, 48, 8);
        IntSummaryStatistics statistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
        System.out.println(statistics.getCount());


    }
}
