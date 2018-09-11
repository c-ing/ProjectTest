package com.java.dynamicProxy;

/**
 * Created by cdc on 2018/4/3.
 */
public class HelloWorld implements IHelloWorld,IWelcome {

    @Override
    public void sayHello() {
        System.out.println("hello world");
    }

    @Override
    public void sayWelcome() {
        System.out.println("welcome");
    }
}
