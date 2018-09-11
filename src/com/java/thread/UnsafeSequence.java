package com.java.thread;

/**
 * Created by cdc on 2018/5/23.
 */
public class UnsafeSequence {
    private int value;

    public int getNext() {
        return ++value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        System.out.println(unsafeSequence.getNext());
        System.out.println(unsafeSequence.getValue());
    }
}
