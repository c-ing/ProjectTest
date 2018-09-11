package com.java.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by cdc on 2018/2/26.
 *
 * about clone demo
 */
public class Employee implements Comparable<Employee>{

    private int id;

    private String name;

    private int age;


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}


    public Employee(int id, String name, int age ){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:"+ id + ",");
        sb.append("name:" + name + ",");
        sb.append("age:" + age);
        return sb.toString();
    }

    @Override
    public int compareTo(Employee o) {
        if (id > o.id){
            return 1;
        }else if (id < o.id){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
       /* Employee employee1 = new Employee();
        System.out.println("before clone: ");
        employee1.setName("zhang san");
        employee1.setAge(24);
        System.out.println("information for employee1：" + employee1);
        System.out.println("after clone: ");
        Employee employee2 = employee1;
        employee2.setName("lisi");
        employee2.setAge(25);
        System.out.println("information for employee1: "+  employee1);
        System.out.println("information for employee2: " + employee2);*/

        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(3,"ZhangSan",21));
        list.add(new Employee(2,"LiSi",22));
        list.add(new Employee(1,"WangWu",23));
        System.out.println("before sort:");
        for (Employee employee : list){
            System.out.println(employee);
        }
        Collections.sort(list);
        System.out.println("after sort:");
        for (Employee employee : list){
            System.out.println(employee);
        }
    }
}
