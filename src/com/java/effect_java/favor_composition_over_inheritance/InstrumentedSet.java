package com.java.effect_java.favor_composition_over_inheritance;


import java.util.Collection;
import java.util.Set;

/**
 * Created by cdc on 2019/1/8.
 *
 *  Wrapper class - uses composition in place of inheritance
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
