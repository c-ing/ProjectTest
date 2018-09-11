package com.java.effect_java.item1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cdc on 2018/6/6.
 */
public class WorlList {

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        // 首先拿到 map 的键值对集合
        Set<Map.Entry<Integer,User>> entrySet = map.entrySet();

        // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
        List<Map.Entry<Integer,User>> list = new ArrayList<>(entrySet);

        // 使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类来实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        LinkedHashMap<Integer,User> linkedHashMap = new LinkedHashMap<Integer,User>();
        //将 List 中的数据存储在 LinkedHashMap 中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        //返回结果
        return linkedHashMap;
    }

    public static HashMap<Integer, String> stringHashMap(HashMap<Integer, String> map) {
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        List<Map.Entry<Integer,String>> list = new ArrayList<>(set);
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("zhangsan", 12));
        users.put(2, new User("lisi",10));
        users.put(3, new User("wangwu", 18));
       /* HashMap<User,Integer> hashMap = new HashMap<>();
        hashMap.put(new User(),1);
        hashMap.put(new User(),2);
        System.out.println(users);*/
       //默认是按键值的升序排序，也可以指定排序的比较器
        /*TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "aa");
        treeMap.put(1, "bb");
        treeMap.put(8, "cc");
        treeMap.put(3, "dd");
        System.out.println("treeMap" + treeMap);*/
        Collections.synchronizedMap(users);
        HashMap<Integer,User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);
    }
}
