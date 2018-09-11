package com.java.thread;

/**
 * Created by cdc on 2018/4/16.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread:" + getId()+ "is running");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            MyThread thread = new MyThread();
            thread.start();
            System.out.println("MyThread 线程对象\n "
                +"线程唯一标识符" + thread.getId() + "\n"
                +"线程名称" + thread.getName() + "\n"
                +"线程状态" + thread.getState() + "\n"
                +"线程优先级" + thread.getPriority());

        }
    }
}
