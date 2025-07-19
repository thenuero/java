package com.nikhiltripathy.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,4,2);

        List<Integer> collect = list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toList());
       // System.out.println(collect);
        int nums[] = {1,2,3,4,5,6,4,2};
        Arrays.asList(nums)
                .stream().forEach(System.out::println);
    }
}
