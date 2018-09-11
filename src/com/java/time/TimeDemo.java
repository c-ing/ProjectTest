package com.java.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

/**
 * Created by cdc on 2018/4/10.
 */
public class TimeDemo {

    public static void main(String[] args) {

        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString());
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss.SSS"));

        LocalDateTime localDateTime = new LocalDateTime();
        System.out.println("localDateTime:" + localDateTime);
    }
}
