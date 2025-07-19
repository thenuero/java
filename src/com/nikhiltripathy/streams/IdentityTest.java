package com.nikhiltripathy.streams;

import java.util.Arrays;
import java.util.function.Function;

public class IdentityTest {
    public static void main(String[] args) {
        Arrays.asList(1,2,3,4,5,6,7)
                .stream()
                .map(Function.identity())
                .forEach(System.out::println);
    }
}
