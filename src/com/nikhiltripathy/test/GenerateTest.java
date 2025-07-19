package com.nikhiltripathy.test;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateTest {

    public static void main(String args[]) {

//        Stream.generate(new Random():: nextInt)
//                .findFirst()
//                .ifPresent(System.out::println);

        Stream.of("Some", "Fucking", "Words", "Which", "Don't", "Mean", "anything")
                .filter(s -> s.length()> 5)
                .forEach(System.out::println);

        System.out.println("Average from a int stream..");

        //Special case in primitive streams..
        IntStream.range(2,56)
                .average()
                .ifPresent(System.out::println);

        System.out.println(IntStream.range(2,56)
                .sum());

        //Laziness of intermediate expression

        Stream.of("Some", "Fucking", "Words", "Which", "Don't", "Mean", "anything")
                .filter(s -> {
                    System.out.println("no body cares..." + s);
                    return true;
                })
                .forEach(s -> System.out.println("foreach " + s));

        //For multiple calls to a stream, setup stream supplier.

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("Some", "Fucking", "Words", "Which", "Don't", "Mean", "anything")
                .filter(s -> s.startsWith("W"));

        System.out.println(streamSupplier.get().count());
        streamSupplier.get().forEach(System.out::println);

    }
}
