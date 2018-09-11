package com.java.single;

/**
 * Created by cdc on 2018/4/11.
 */
public class Hunger {

    private static final Hunger INSTANCE = new Hunger();

    private Hunger(){};

    public Hunger getInstance(){
        return INSTANCE;
    }
}
