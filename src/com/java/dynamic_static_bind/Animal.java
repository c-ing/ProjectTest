package com.java.dynamic_static_bind;

/**
 * Created by cdc on 2018/8/24.
 */
public class Animal {

    public void sayName() {
        System.out.println("I am animal");
    }

    public void eat() {
        System.out.println("animal:  is eatting");
    }

    public static void sayHello() {
        System.out.println("animal: hello");
    }

    private void sayGoodbye() {
        System.out.println("animal: goodbye");
    }
}
