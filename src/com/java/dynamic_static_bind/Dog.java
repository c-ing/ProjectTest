package com.java.dynamic_static_bind;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cdc on 2018/8/24.
 */
public class Dog extends Animal {

    @Override
    public void sayName() {
        System.out.println("I am dog");
    }

    Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void play() {
        System.out.println("dog: play");
    }


    public void setCount(Integer count) {
        this.count = count;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setCount(1);
        System.out.println(dog.getCount());

        Dog dog1 = new Dog();

        System.out.println(dog1.getCount());

        String[] array = {"foo", "bar"};
        List<String> list = Arrays.asList(array);
        System.out.println(array[0] + "," + list.get(0));
        array[0] = "food";
        System.out.println(array[0] + "," + list.get(0));
    }

}