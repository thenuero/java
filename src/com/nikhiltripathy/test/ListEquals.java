package com.nikhiltripathy.test;

import java.util.ArrayList;
import java.util.List;

public class ListEquals {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        List<Integer> copy = new ArrayList<>();
        list.add(1);
        list.add(-1);
        list.add(0);

        copy.add(-1);
        copy.add(1);
        copy.add(0);

        System.out.println(list.equals(copy));

    }
}
