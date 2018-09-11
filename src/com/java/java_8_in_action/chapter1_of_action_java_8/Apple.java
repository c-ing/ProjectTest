package com.java.java_8_in_action.chapter1_of_action_java_8;

/**
 * Created by cdc on 2018/4/18.
 */
public class Apple {

    public int weight = 0;
    private String color = "";

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Apple(){};

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

}
