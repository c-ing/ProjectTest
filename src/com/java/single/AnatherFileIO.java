package com.java.single;

/**
 * Created by cdc on 2018/4/11.
 * 线程安全-静态内部类的单例模式
 */


public class AnatherFileIO {

    private static final class AnatherFileIOHolder{
        private static final AnatherFileIO INSTANCE = new AnatherFileIO();
    }
    private AnatherFileIO(){};

    public static AnatherFileIO getInstance(){
        return AnatherFileIOHolder.INSTANCE;
    }

    public static void main(String[] args) {
        //黑客破坏-反射和反序列化
        try {
            //反射调用构造方法初始化新的变量
            AnatherFileIO anatherFileIO = AnatherFileIO.class.newInstance();
            AnatherFileIO anatherFileIO2 = AnatherFileIO.class.newInstance();
            System.out.println("黑客破坏-反射: " + (anatherFileIO == anatherFileIO2));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
