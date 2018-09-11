package com.java.demo;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by cdc on 2018/4/3.
 */
public class orderDemo {

    public static void main(String[] args) {
        GoodsCategory g1 = new GoodsCategory(7,4, "aa",1);
        GoodsCategory g2 = new GoodsCategory(9,4,"dd",3);
        GoodsCategory g3 = new GoodsCategory(8,4,"dd",2);

        List<GoodsCategory> list = new ArrayList<>();

        list.add(g1);
        list.add(g2);
        list.add(g3);

        System.out.println("before sort:" + list);

        Comparator<GoodsCategory> gcComparator = Ordering.from(new Comparator<GoodsCategory>() {
            @Override
            public int compare(GoodsCategory o1, GoodsCategory o2) {
                return o1.getSortIndex().compareTo(o2.getSortIndex());
            }
        }).compound(new Comparator<GoodsCategory>() {
            @Override
            public int compare(GoodsCategory o1, GoodsCategory o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        Comparator<GoodsCategory> gcComparatorNature = Ordering.natural().onResultOf(new Function<GoodsCategory, Comparable>() {
            @Override
            public Comparable apply(GoodsCategory goodsCategory) {
                return goodsCategory.getName();
            }
        }).compound(new Comparator<GoodsCategory>() {
            @Override
            public int compare(GoodsCategory o1, GoodsCategory o2) {
                return o1.getSortIndex().compareTo(o2.getSortIndex());
            }
        });

        Collections.sort(list,gcComparatorNature);
        System.out.println("after sort:" + list);

        System.out.println(BigDecimal.ONE);
        System.out.println(BigDecimal.ZERO);

        Multimap<String,String> map = ArrayListMultimap.create();
        Map<String,String> map2 = new HashMap<>();

        map.put("aa","11");
        map.put("aa","22");

        map2.put("aa","11");
        map2.put("aa","22");

        System.out.println(map);
        System.out.println(map2);
        Collection<String> aa = map.get("aa");
        System.out.println(aa);
    }

}
