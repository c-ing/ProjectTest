package com.java.reentrantlock_synchronized;

/**
 * Created by cdc on 2018/5/23.
 */
public class Test {
    /**
     * 我们有意先去“写”，然后让“读”等待，“写”的时间是无穷的，就看“读”能不能放弃了。
     */
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
       /* final Writer writer = new Writer(buffer);
        final Reader reader = new Reader(buffer);
        writer.start();
        reader.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (;;) {
                    //等5秒去中断读
                    if (System.currentTimeMillis() - start > 5000) {
                        System.out.println("不等了，尝试中断");
                        reader.interrupt();
                        break;
                    }
                }
            }
        }).start();*/
    }
}
