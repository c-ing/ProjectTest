package com.java.single;

/**
 * Created by cdc on 2018/4/11.
 */
public class test implements Runnable{

    @Override
    public void run() {
        System.out.println(Lazy.getInstance());
    }

    public static void main(String[] args) {
        test test = new test();
        test test1 = new test();
        test test2 = new test();
        test.run();
        test1.run();
        test2.run();

        //黑客破坏-反射和反序列化
        try {
            //反射调用构造方法初始化新的变量
            AnatherFileIO anatherFileIO = AnatherFileIO.class.newInstance();
            AnatherFileIO anatherFileIO2 = AnatherFileIO.class.newInstance();
            System.out.println("黑客破坏-反射" + (anatherFileIO == anatherFileIO2));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
