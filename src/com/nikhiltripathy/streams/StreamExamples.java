package com.nikhiltripathy.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        Stream<String> stream = stringList.stream();

        List<String> lowerCase = stream
                .map(String::toLowerCase)
                .toList();

        long count = stringList.stream()
                .map(String::toLowerCase)
                .count();

        lowerCase
                .forEach(System.out::println);

        System.out.println(count);

    }
}
