package com.nikhiltripathy.streams;

import java.util.stream.Stream;

/**
 * Created on 30/08/2025 at 11:31
 * Author: theneuro
 */

public class StreamsGenerate {

    public static void main(String[] args) {
        //Infinite stream.
        Stream<String> generate = Stream.generate(() -> "Echo");
        Stream<Double> generate1 = Stream.generate(Math::random);

        generate1.forEach(System.out::println);
    }
}