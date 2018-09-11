package com.java.thread;

/**
 * Created by cdc on 2018/4/16.
 */
public class MyThreadBrother implements Runnable {
    @Override
    public void run() {

        while (true){

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(new MyThreadBrother() );
            thread.start();
            System.out.println("MyThreadBrother " + thread.getId());
        }
    }
}
