package com.java.design_model.template_method;

/**
 * Created by cdc on 2018/7/14.
 */
public class Person {

    private Integer id;
    private String name;
    private Address address;

    Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    Person(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
