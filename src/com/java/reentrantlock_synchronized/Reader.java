package com.java.reentrantlock_synchronized;

/**
 * Created by cdc on 2018/5/23.
 */
public class Reader extends Thread {

    /*private Buffer buffer;

    public Reader(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.read(); //这里估计会一直阻塞
        System.out.println("读结束");
    }
    */

    private BufferInturruptibly bufferInturruptibly;

    public Reader(BufferInturruptibly bufferInturruptibly) {
        this.bufferInturruptibly = bufferInturruptibly;
    }
    @Override
    public void run() {
        try {
            bufferInturruptibly.read();//可以收到中断的异常，从而有效退出
        } catch (Exception e) {
            System.out.println("我不读了");
        }
        System.out.println("读结束");
    }
}
