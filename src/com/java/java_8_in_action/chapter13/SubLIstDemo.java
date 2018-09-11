package com.java.java_8_in_action.chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by cdc on 2018/5/7.
 */
public class SubLIstDemo {
    static List<List<Integer>> subSets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            System.out.println("ans:" + ans);
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans = subSets(rest);
        List<List<Integer>> suhans2 = insertAll(first,subans);
        return concat(subans,suhans2);
    }

    static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        System.out.println("result:" +result);
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        a.addAll(b);
        System.out.println("a:" + a);
        return a;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4);
        System.out.println("subSets:" + subSets(list));
    }
}
