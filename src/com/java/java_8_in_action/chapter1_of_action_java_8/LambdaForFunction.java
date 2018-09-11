package com.java.java_8_in_action.chapter1_of_action_java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by cdc on 2018/4/19.
 */
public class LambdaForFunction {

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T s : list){
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> l = Arrays.asList("china","jpan","usa");
        List<Integer> integerList = LambdaForFunction.map(l,(String s) -> s.length() > 3 ? s.length():0);
        System.out.println(integerList);
    }
}
