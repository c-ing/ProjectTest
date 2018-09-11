package com.java.clone;

import java.util.HashMap;

/**
 * Created by cdc on 2018/4/13.
 */
public class Asian {
    private String skin;
    Person person;

    public Asian(String skin, Person person){
        this.skin = skin;
        this.person = person;
    }

    public Asian(Asian asian){
        this.skin = asian.skin;
        this.person = asian.person;
    }

    public static void main(String[] args) {
        Person p1 = new Person("lisi","man",23);
        Person p2 = new Person(p1);
        System.out.println(p1 == p2);

        Asian a1 = new Asian("yellow",new Person("lisi","man",23));
        Asian a2 = new Asian(a1);
        System.out.println(a1 == a2);

        HashMap<String,Integer> h1 = new HashMap();
        h1.put("aa",11);   //星言石语
        h1.put("bb",22);
        System.out.println(h1);
    }
}
