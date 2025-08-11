package com.nikhiltripathy.functional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class CollectionSorting {
    public static void main(String[] args) {
        //Old style, verbose
        List<Integer> integers = new java.util.ArrayList<>(List.of(1, 4, 3, 2));
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        });

        Collections.sort(integers, Integer::compareTo);
    }
}
