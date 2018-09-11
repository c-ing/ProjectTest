package com.java.demo;

import com.sun.jmx.snmp.InetAddressAcl;

/**
 * Created by cdc on 2018/2/26.
 */
public class Address {

    private String state;

    private String province;  // addcdfferowj

    private String city;

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}

    public String getProvince() {return province;}

    public void setProvince(String province) {this.province = province;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public Address(String state, String province, String city){
        this.state = state;
        this.province = province;
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("国家:" + state +",");
        sb.append("省: " + province + ",");
        sb.append("市: " + city );
        return sb.toString();
    }

    private Address(){};

    private static Address a = null;

    public static Address getInstance(){
        if (a == null)
            a = new Address();
        return a;
    }

    public static void main(String[] args) {
        Address a1 = Address.getInstance();
        Address a2 = Address.getInstance();
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));
    }
}
