package com.java.demo;

/**
 * Created by cdc on 2018/2/25.
 */
public class Emperor {

    private static Emperor emperor = null;
    private Emperor(){
    }

    public static Emperor getInstance(){
        if (emperor == null){
            emperor = new Emperor();
        }
        return emperor;
    }
    public void getName(){
        System.out.println("我是皇帝：唯一 单实例");
    }

    public static void main(String[] args) {
       /* System.out.println("创建皇帝1对象：");
        Emperor emperor1 = Emperor.getInstance();
        emperor1.getName();
        System.out.println("创建皇帝2对象：");
        Emperor emperor2 = Emperor.getInstance();
        emperor2.getName();
        System.out.println("创建皇帝3对象：");
        Emperor emperor3 = Emperor.getInstance();
        emperor3.getName();*/

       int a = 0;

        System.out.println(a == 1 ? true : a == 2 ? true : "a == 0 ");
    }
}
