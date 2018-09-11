package com.java.java_151_adivces.chapter_6;

/**
 * Created by cdc on 2018/5/14.
 */
public enum Season {
    Spring, Summer, Autumn, Winter;

    //最舒服的季节
    public static Season getComfortableSeason() {
        return Spring;
    }

    public static void main(String[] args) {
        System.out.println(Season.getComfortableSeason());
    }
}
