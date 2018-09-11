package com.java.java_8_in_action.chapter1_of_action_java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Created by cdc on 2018/4/18.
 */
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> invertory = Arrays.asList(new Apple(80,"green"),
                new Apple(155,"green"),
                new Apple(125,"red"),
                new Apple(155,"blue"));
        //选出绿苹果
        //System.out.println(filterGreenApples(invertory));

        //选出超过150克的苹果
        //System.out.println(filterHeavyApples(invertory));

        //java 8 之后
        System.out.println("after java 8");
       // System.out.println(filterApples(invertory,FilteringApples::isGreenApple));
        //或者使用匿名函数
        System.out.println(filterApples(invertory,(Apple a) -> "green".equals(a.getColor()) ));
        System.out.println(filterApples(invertory,(Apple a) -> a.getWeight() > 120 && a.getWeight() < 150));
        //Stream Api顺序处理：
        System.out.println(invertory.stream().filter((Apple a) -> "red".equals(a.getColor())).collect(toList()));

        //Stream Api并行处理：
        System.out.println(invertory.parallelStream().filter((Apple a) -> a.getWeight() > 120).collect(toList()));

        //comparator例子
        System.out.println("---------comparator test------------");
        invertory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o2.getWeight().compareTo(o1.getWeight());
            }
        });
        System.out.println(invertory);

        //Lambda表达式排序
        invertory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(invertory);


        //
        invertory.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor).reversed());
        System.out.println("sort:" + invertory);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

   /* public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }*/

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
