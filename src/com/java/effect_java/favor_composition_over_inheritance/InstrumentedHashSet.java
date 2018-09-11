package com.java.effect_java.favor_composition_over_inheritance;

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
        System.out.println(instrumentedHashSet.getAddCount());
        System.out.println(instrumentedHashSet.toString());
    }
}
