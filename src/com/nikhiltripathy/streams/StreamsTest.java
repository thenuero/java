package com.nikhiltripathy.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/* Two phases of streams..
1. Configuration - non terminal ops (filtering , mapping etc.. )
2. Processing - terminal ops
* */
public class StreamsTest {

    public static void main(String[] args) {
	// write your code here
        List<Integer> num = List.of(12,3,45,76,123,98,4320);
        //Alternative of getting the stream
        Stream<String> names = Stream.of("Alex", "Sam", "Dan", "Newton");

        //names.forEach(System.out::println);
        Stream<Integer> integerStream = num.stream()
                .filter(n -> n % 2 == 0);
        //integerStream.forEach(System.out::println);
        // Below statement is illegal, streams can be operated only once.
        // System.out.println(integerStream.count());

        List<String> collect = names.filter(name -> name.length() > 3)
                        .map(String::toUpperCase)
                                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        //Test for optional
        Optional opt = areaOfSquare(4);
        opt.ifPresent(System.out::println);
    }

    public static Optional<Double> areaOfSquare(int x) {
        Optional<Double> result = x == 0 ? Optional.empty() : Optional.of(Math.pow(x,2));
         return result;
    }
}
