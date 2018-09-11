package com.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by cdc on 2018/4/18.
 */
public class LambdaForPredicate {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages,(str) -> str.startsWith("J"));

        System.out.println("Languages which starts ends with a :");
        filter(languages,(str) -> str.endsWith("a"));

        System.out.println("print all languages :");
        filter(languages,(str) -> true);

        System.out.println("print no langusge :");
        filter(languages,(str) -> false);

        System.out.println("Print language whose length greater than 4 :");
        filter(languages,(str) -> size(str.length()));


        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }

    public static void filter(List<String> names, Predicate<String> condition){
        for (String name : names){
            if (condition.test(name)){
                System.out.println(name + " ");
            }
        }
    }

    // 更好的办法
    public static void filter2(List<String> names, Predicate<String> condition){
        names.stream().filter((name) -> (condition.test(name))).forEach((name) ->{
            System.out.println(name + " ");
        });
    }

    public static boolean size(int size){
        if (size > 4){
            return true;
        }
        return false;
    }


}
