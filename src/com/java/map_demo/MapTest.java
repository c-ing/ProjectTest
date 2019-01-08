package com.java.map_demo;


import java.util.Arrays;
import java.util.List;

/**
 * Created by cdc on 2018/9/11.
 */
public class MapTest {

    Integer[] ints = {1, 2, 5, 6};
    List<Integer> list = Arrays.asList(ints);

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.list.set(2, 8);
        System.out.println(mapTest.list.get(2));
        System.out.println(mapTest.ints[2]);
    }
}
