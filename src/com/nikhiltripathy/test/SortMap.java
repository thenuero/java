package com.nikhiltripathy.test;

import java.util.*;
import java.util.stream.Collectors;

public class SortMap {
    //Write a Program to Sort HashMap by values?
    public void sortMap(HashMap<String,Integer> hm) {
        List<Map.Entry<String, Integer> > list
                = new LinkedList<Map.Entry<String, Integer> >(
                hm.entrySet());
        Collections.sort(list, (a,b) -> {
            return a.getValue().compareTo(b.getValue());
        });

    }
}
