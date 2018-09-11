package com.java.single;

/**
 * Created by cdc on 2018/4/11.
 *
 * 线程安全-双重检验锁
 */
public class FileIO {

    private static volatile FileIO fileIO;

    private FileIO(){};

    public static FileIO getInstance(){
        if (fileIO == null){
            synchronized (FileIO.class){
                if (fileIO == null){
                    fileIO = new FileIO();
                }
            }
        }
        return fileIO;

        //......
    }
}
