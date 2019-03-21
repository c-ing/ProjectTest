package com.java.effect_java.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cdc on 2019/2/13.
 *
 * 假设你要编写⼀个Chooser类，其构造⽅法接收⼀个集合，它还提供了⼀个⽅法，
 * 随机返回集合中的⼀个元素。根据向构造⽅法所传递的集合的不同，你可以将该选择器作为
 * ⼀个骰⼦、⼀个魔术⼋球，或是⼀个蒙特卡罗模拟的数据源
 */
public class Chooser<T> {

    private final List<T> choiceList;
    public Chooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(3);

        Chooser chooser = new Chooser(list);
        int result = (int)chooser.choose();
        System.out.println(result);
    }
}
