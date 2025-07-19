package com.nikhiltripathy.lambdas;

import com.nikhiltripathy.utils.PrintToStd;

import java.util.Arrays;
import java.util.Comparator;

public class StringComparator {

    public static void main(String[] args) {

        Comparator <String> comp = (s,t) ->
            Integer.compare(s.length() , t.length());

        String[] arr = new String[] {"cricket", "badminton", "baseball"};

        Arrays.sort(arr, comp);

        PrintToStd.printArray(arr);
       // PrintToStd.printArray(new Integer[] {1,2,3});
        PrintToStd.printList(Arrays.asList(new Integer[] {1,2,3}));
    }
}
