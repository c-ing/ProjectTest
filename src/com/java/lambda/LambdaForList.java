package com.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdc on 2018/4/18.
 */
public class LambdaForList {
    public static void main(String[] args) {
        //java 8 之前
        List<String> features = Arrays.asList("Lambdas","Deafult Method","Stream Api","Date and Time Api");
        for (String feature : features){
            System.out.println(feature);
        }

        //java 8 之后
        List<String> features2 = Arrays.asList("Lambdas","Deafult Method","Stream Api","Date and Time Api");
        features2.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features2.forEach(System.out :: println);
    }
}
