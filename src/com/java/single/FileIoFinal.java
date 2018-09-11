package com.java.single;

/**
 * Created by cdc on 2018/4/11.
 * 枚举实现单例模式
 */
public enum FileIoFinal {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(FileIoFinal.INSTANCE);

    }
}
