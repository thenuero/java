package com.nikhiltripathy.utils;

import java.util.List;

public class PrintToStd {

    public static <T>void printArray (T arr[]) {
        for (T s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static <T>void printList(List<T> list) {
       list.forEach(System.out::print);
    }
}
