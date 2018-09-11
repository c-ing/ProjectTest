package com.java.java_8_in_action.chapter1_of_action_java_8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by cdc on 2018/4/19.
 */
public class LambdaForConsumer {
    public static <T> void forEach(List<T> list,Consumer<T> consumer){
       for (T i : list ){
            consumer.accept(i);
       }
    }

    public static void main(String[] args) {
        Apple a = new Apple();
        List<Integer> list = Arrays.asList(1,2,3,4);
        LambdaForConsumer.forEach(list,(Integer i) -> a.weight = i +3 );
        System.out.println(a.getWeight());
    }
}
