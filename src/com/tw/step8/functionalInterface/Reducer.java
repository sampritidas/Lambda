package com.tw.step8.functionalInterface;

public interface Reducer<C, T> {
    C apply(C c, T t);
}
