package com.tw.step8.functionalInterface;

import java.util.ArrayList;
import java.util.Collection;

public class Numbers<I extends Number> extends ArrayList<I> {
    public Numbers() {}

    public Numbers(Collection<I> c) {
        super(c);
    }

    public Numbers<I> filter(Predicate<I> predicate) {
        Numbers<I> evens = new Numbers<>();
        for (I integer : this) {
            if(predicate.apply(integer)) {
                evens.add(integer);
            }
        }
        return evens;
    }

    public <R> R reduce(Reducer<R, I> reducer, R initialContext) {
        R context = initialContext;
        for (I integer : this) {
            context = reducer.apply(context, integer);
        }
        return context;
    }

    public ArrayList<I> map(Mapper<I> mapper) {
        ArrayList<I> mappedArray = new ArrayList<>();
        for (I i : this) {
            mappedArray.add(mapper.apply(i));
        }
        return mappedArray;
    }
}
