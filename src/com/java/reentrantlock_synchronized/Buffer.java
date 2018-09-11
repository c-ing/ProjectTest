package com.java.reentrantlock_synchronized;

/**
 * Created by cdc on 2018/5/23.
 */
public class Buffer {
    private Object lock;

    public Buffer() {
        lock = this;
    }

    public void write() {
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buffer写入数据...");
            for (;;) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }
            System.out.println("终于写完了");
        }
    }

    public void read() {
        synchronized (lock) {
            System.out.println("从这个buffer读取数据");
        }
    }


}
