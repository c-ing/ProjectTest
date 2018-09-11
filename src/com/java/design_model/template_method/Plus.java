package com.java.design_model.template_method;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by cdc on 2018/6/22.
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1, int num2) {
        System.out.println("子类Plus的calculate被调用");
        return num1 + num2;
    }

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
       // int result = cal.calculate(exp, "\\+");
        int result = cal.calculate(1, 1);
        System.out.println("result" + result);
        System.out.println("======================");
        Person p1 = new Person(1, "zhangsan",new Address(1,"华山路"));
        Person p2 = new Person(2,"lisi",new Address(2,"黄山路"));
        Person p3 = new Person(3,"wangwu",new Address(3,"泰山路"));
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
       // Set set = new HashSet<>(list.get());
        //System.out.println(set);
        List<String> ids = list.stream().map(Person::getAddress).map(Address::getStreet).collect(toList());
        System.out.println(ids);

        for (int i = 0; i < 5; i++) {
            System.out.println("i: " + i);
            if (i == 1) {
                continue;
            }
            System.out.println("didi");
        }

        System.out.println("lambda 捕获局部变量测试");
        for (int i = 0; i < list.size(); i++){
            Integer personId = list.get(i).getId();
            List<Person> list1 = list.stream().filter(person -> person.getId().intValue() >= personId).collect(toList());
            if (list1 == null || list1.size() < 1) {
                System.out.println("null");
            }

            list.get(i).getAddress().setStreet("hhhh");
            //personId = 0;
        }

        Date date = new Date(114,2,18);
        System.out.println("date: " + date);
    }
}