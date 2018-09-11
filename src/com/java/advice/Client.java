package com.java.advice;

import java.util.Scanner;

/**
 * Created by cdc on 2018/4/4.
 */
public class Client {

    public static void main(String[] args) {
        //接受键盘输入参数1
       /* Scanner input = new Scanner(System.in);
        System.out.println("请输入多个数判断奇偶：");
        while (input.hasNextInt()){
            int i = input.nextInt();
           // String str = i + "->" + (i % 2 == 1 ? "奇数" : "偶数"); //不好的写法
            String str1 = i + "->" + (i % 2 == 0 ? "奇数" : "偶数");
            System.out.println(str1);
        }*/

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello, dusk!");
            }
        });

        thread.start();
    }

}
