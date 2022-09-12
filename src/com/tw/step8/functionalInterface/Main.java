package com.tw.step8.functionalInterface;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Numbers<Integer> numbers = new Numbers<>(Arrays.asList(3, 4, 8, 2));
        System.out.println(numbers);

        //reduce
        System.out.println("Reduce  " + numbers.reduce(new Reducer<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }, 10));

        System.out.println("Reduce  " + numbers.reduce((integer, integer2) -> integer + integer2, 20));


        //filter
        final Numbers<Integer> evenNumbers = numbers.filter(new Predicate<Integer>() {
            @Override
            public boolean apply(Integer integer) {
                return integer % 2 == 0;
            }
        });
        System.out.println("Filter  " + evenNumbers);

        final Numbers<Integer> evenNumbers2 = numbers.filter(integer -> integer % 2 == 0);
        System.out.println("Filter  " + evenNumbers2);


        //map
        System.out.println("Map     " + numbers.map(new Mapper<Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i * i;
            }
        }));
        System.out.println("Map     " + numbers.map(i -> i * i * i));

        //forEach
        numbers.forEach(new Iterable<Integer, Integer>() {

            @Override
            public void apply(Integer i, int index) {
                System.out.format("element %d : %d \n", index, i);
            }
        });

    }
}