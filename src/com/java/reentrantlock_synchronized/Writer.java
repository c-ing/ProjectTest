package com.java.reentrantlock_synchronized;

/**
 * Created by cdc on 2018/5/23.
 */
public class Writer extends Thread {
    private Buffer buffer;

    public Writer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.write();
    }
}
