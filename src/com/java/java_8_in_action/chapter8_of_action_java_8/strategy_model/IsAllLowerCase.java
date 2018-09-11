package com.java.java_8_in_action.chapter8_of_action_java_8.strategy_model;

/**
 * Created by cdc on 2018/5/2.
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
