package com.nikhiltripathy.test;

import java.util.ArrayList;
import java.util.List;

public class ListAdd {
    public static void main(String[] args) {
        List<List<Integer>> mainlist = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        mainlist.add(list1);
        mainlist.add(list2);

        mainlist.forEach(System.out::println);

    }
}
