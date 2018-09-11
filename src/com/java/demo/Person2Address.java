package com.java.demo;

/**
 * Created by cdc on 2018/2/26.
 */
public class Person2Address implements Cloneable{

    private String name;

    private Address address;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Address getAddress() {return address;}

    public void setAddress(Address address) {this.address = address;}

    public Person2Address(String name, Address address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("姓名:" + name + ",");
        sb.append("地址:" + address);
        return sb.toString();
    }

    @Override
    public Person2Address clone()  {
        Person2Address pa = null;
        try {
            pa = (Person2Address) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return pa;
    }

    public static void main(String[] args) {
        Address address = new Address("China", "FuJian","FuZhou");
        Person2Address pa1 = new Person2Address("ZhangSan",address);
        System.out.println("before clone: " + pa1);
        System.out.println("after clone:");
        Person2Address pa2 = pa1.clone();
        System.out.println("pa2: " + pa2);
        pa2.getAddress().setState("China");
        pa2.getAddress().setProvince("SiChuang");
        pa2.getAddress().setCity("ChengDu");
        pa2.setName("LiSi");
        System.out.println("pa1: " + pa1);
        System.out.println("pa2: " + pa2);

        int size = pa2.getName().length();
        System.out.println(size);
    }
}
