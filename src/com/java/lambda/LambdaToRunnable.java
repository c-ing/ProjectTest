package com.java.lambda;

/**
 * Created by cdc on 2018/4/18.
 *
 * 用lambda表达式实现Runnable
 */
public class LambdaToRunnable {

    public static void main(String[] args) {
        //java8 之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //java 8 方式
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }
}
