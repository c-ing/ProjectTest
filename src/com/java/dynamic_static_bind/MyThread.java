package com.java.dynamic_static_bind;

/**
 * Created by cdc on 2018/8/24.
 */
public class MyThread implements Runnable {
    Integer b = 0;
    @Override
    public void run() {
        Dog dog = new Dog();
        dog.getCount();
        b ++;
        System.out.println("b: " + b);
    }
}
