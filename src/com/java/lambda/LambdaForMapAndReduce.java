package com.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cdc on 2018/4/18.
 */
public class LambdaForMapAndReduce {


    public static void main(String[] args) {
        //不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100,200,300,400,500);
        for (Integer cost : costBeforeTax){
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        //使用lambda表达式
       // List<Integer> costBeforeTax = Arrays.asList(100,200,300,400,500);
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);

        //计算总和
        double total = costBeforeTax.stream().map((cost) -> .12*cost).reduce((sum,cost) -> sum + cost).get();
        System.out.println("total:" + total);

        List<String> strList = Arrays.asList("china", "us","japan","german");
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(G7Countries);
    }
}
