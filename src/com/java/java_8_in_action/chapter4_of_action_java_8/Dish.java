package com.java.java_8_in_action.chapter4_of_action_java_8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Created by cdc on 2018/4/20.
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT, FISH, OTHER}

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<Integer> threeHighCaloricDishNames =
                menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(d -> d.getName().length())
                .limit(3)
                .collect(toList());
        System.out.println(threeHighCaloricDishNames);


        List<String> threeHighCaloricDishNamesR =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(d -> d.getName().replaceAll("e",""))
                        //.limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNamesR);


        long count = menu.stream().count();
        System.out.println("the size of menu :" + count);

        Integer conunt2 = menu.stream()
                .map(d -> 1)
                .reduce(0,Integer::sum);
        System.out.println(conunt2);

        //收集器
        Optional<Dish> dish = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(dish);

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories:" + totalCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("menuStatistics"+menuStatistics);

        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println("shortMenu:" + shortMenu);

        System.out.println();
        System.out.println("==============分组1========================");
        //分组1.
        System.out.println("before group :" + menu.toString());
        Map<Dish.Type,List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("dishesByType:" + dishesByType);

        System.out.println();
        System.out.println("==============分组2=======没有自定义的方法=====");
        //分组2.
        Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(d ->{
                    if (d.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })
        );
        System.out.println("dishesByCaloricLevel:" + dishesByCaloricLevel);

        System.out.println();
        System.out.println("============多级分组===分组1 + 分组2 =========");
        //多级分组
        System.out.println("before goup: " + menu);
        Map<Dish.Type, Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(d -> {
                                    if (d.getCalories() <=400) return CaloricLevel.DIET;
                                    else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                })
                        )
                );
        System.out.println("dishesByTypeCaloricLevel:" + dishesByTypeCaloricLevel);

        System.out.println();
        System.out.println("====数一数菜单中每类菜有多少个===");
        Map<Dish.Type,Long> dishesByTypeCount = menu.stream().collect(groupingBy(Dish::getType,counting()));
        System.out.println("dishesByTypeCount: " + dishesByTypeCount);

        System.out.println();
        System.out.println("查找每个子组中热量最高的Dish:");
        Map<Dish.Type, Dish> mostCaloricLevelByType = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("mostCaloricLevelByType: " + mostCaloricLevelByType);

        System.out.println("\n");
        int a = 1;
        Integer a_integer = Integer.valueOf(a);
        int b = 0;
        Integer b_integer = Integer.valueOf(b);
        System.out.println();


    }
}

