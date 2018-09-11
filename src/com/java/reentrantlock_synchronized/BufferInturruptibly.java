package com.java.reentrantlock_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cdc on 2018/5/23.
 */
public class BufferInturruptibly {

    private static Lock lock = new ReentrantLock();

    public BufferInturruptibly() {
      //  lock = this;
    }

    public void write() {
        try {
            lock.lock();
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buffer写入数据...");
            for (; ; ) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }
            System.out.println("终于写完了");
        } catch (Throwable e) {
            throw e;
        }finally {
            lock.unlock();
        }

    }

    public void read() {
        lock.lock();
        try {
            System.out.println("从这个buffer读取数据");
        } catch (Throwable e) {
            throw e;
        }finally {
            lock.unlock();
        }
    }
}
