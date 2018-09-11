package com.java.effect_java.item1;

/**
 * Created by cdc on 2018/6/8.
 */
public class VolatileDemo {

    private static volatile boolean isOver = false;
   // private final  int a;
   // a=1;
    public VolatileDemo() {
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver);
            }
        });
        thread.start();
        try {
            thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}
