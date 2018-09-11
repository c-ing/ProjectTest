package com.java.design_model.template_method;

/**
 * Created by cdc on 2018/7/16.
 */
public class Address {

    private Integer id;
    private String street;

    public Address(Integer id, String street) {
        this.id = id;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
