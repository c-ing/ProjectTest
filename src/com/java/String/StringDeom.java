package com.java.String;

import org.joda.time.Days;

/**
 * Created by cdc on 2018/4/10.
 */
public class StringDeom {

    public String stringMethod(){
        String s = "abcd";
        s = s + "1234";
        s = s.substring(0, 2);
        s = s.toUpperCase();
        return s.toString();
    }

    public static String insertPercent(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            sb.append("%").append(str.charAt(i));
        }
        sb.append("%");
        return sb.toString();
    }

    public static void main(String[] args) {
        StringDeom sd = new StringDeom();
        sd.stringMethod();

        String name = "a_B_'";
        String name1 = name.replaceAll("_","").replaceAll("'","");
        System.out.println("name1: " + name1);
        System.out.println(StringDeom.insertPercent(name1));
    }
}
