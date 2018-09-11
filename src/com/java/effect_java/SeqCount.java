package com.java.effect_java;

/**
 * Created by cdc on 2018/5/29.
 */
public class SeqCount {
    private static ThreadLocal<Integer> seqCount = new ThreadLocal<Integer>(){

        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int nextSeq() {
        seqCount.set(seqCount.get() + 1);
        return seqCount.get();
    }

    public static void main(String[] args) {
        SeqCount seqCount = new SeqCount();
        SeqThread thread1 = new SeqThread(seqCount);
        SeqThread thread2 = new SeqThread(seqCount);
        SeqThread thread3 = new SeqThread(seqCount);
        SeqThread thread4 = new SeqThread(seqCount);


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private static class SeqThread extends Thread {
        private SeqCount seqCount;

        SeqThread(SeqCount seqCount) {
            this.seqCount = seqCount;
            System.out.println("seqCount" + seqCount);
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "seqCount:" + seqCount.nextSeq());
            }
        }
    }

}
