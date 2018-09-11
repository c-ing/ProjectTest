package com.java.clone;

/**
 * Created by cdc on 2018/4/13.
 */
public class Person {
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Person(Person p){  ////拷贝构造方法，复制对象
        this.name = p.name;
        this.sex = p.sex;
        this.age = p.age;
    }
}
