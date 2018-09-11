package com.java.java_8_in_action.chapter5_of_action_java_8;

/**
 * Created by cdc on 2018/4/21.
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader (String name, String city){
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
