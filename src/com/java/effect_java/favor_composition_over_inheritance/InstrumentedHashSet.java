package com.java.effect_java.favor_composition_over_inheritance;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by cdc on 2018/8/30.
 */
public class InstrumentedHashSet extends HashSet {

    private int addCount = 0;

    public InstrumentedHashSet(){};

    public InstrumentedHashSet(int initCap, int loadFactor) {
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(Object o) {
        addCount ++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet instrumentedHashSet = new InstrumentedHashSet();
        instrumentedHashSet.addAll(Arrays.asList("a", "b", "c"));
        // instrumentedHashSet.addAll(List.of("Snap", "Crackle", “Pop"));
        System.out.println(instrumentedHashSet.getAddCount());
        System.out.println(instrumentedHashSet.toString());

       /*// 找零时刻
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
        System.out.println(new BigDecimal(2.10));
        System.out.println(new BigDecimal("2.10"));

        //长整除
        final long MICROS_PER_DAY = 24L * 60 *60 * 1000 * 1000; //86400 000 000   int 最大值为2147 483 647
        System.out.println(MICROS_PER_DAY);
        final long MILIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY/MILIS_PER_DAY);

        //多重转型
        System.out.println("多重转型:");
        System.out.println((int)(char)(byte)-1);*/
    }
}
