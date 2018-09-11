package com.java.java_8_in_action.chapter10_of_aciton_java_8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by cdc on 2018/7/30.
 */
public class Person {
    private Optional<Car> car;
    public Optional<Car> getCar(){return car;}

    public static void main(String[] args) {
        //使用 map 从 Optional 对象中提取和转换值
        Insurance insurance = new Insurance();
        insurance.setName("人寿保险");
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        System.out.println("使用 map 从 Optional 对象中提取和转换值: " + name.get());

        System.out.println();
        Integer[] array = {1, 2, 3};
        List<Integer> list = Arrays.asList(array);
        for ( Integer i : list) {

        }
    }
}
