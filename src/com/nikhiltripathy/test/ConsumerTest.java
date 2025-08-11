package com.nikhiltripathy.test;

import java.util.Arrays;
import java.util.List;

public class ConsumerTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Nikhil", "Jamshedpur", "India", "Random");
        list.forEach((txt) -> {
            int x = 0;
            System.out.print(txt + "___ " + x);
        });
    }
}
