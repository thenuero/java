package com.nikhiltripathy.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 30/08/2025 at 12:08
 * Author: theneuro
 */

public class StreamDump {
    public static void main(String[] args) {

        Stream<Character> concat = Stream.concat("Nikhil".chars().mapToObj(c -> (char) c), "Tripathy".chars().mapToObj(c -> (char) c));
        //concat.forEach(System.out::println);


        Optional<String> max = Arrays.stream("Other simple reductions are max and min that return the largest or smallest value.".split("[\\P{L}]+"))
                .max(String::compareToIgnoreCase);

        Optional<String> r = Arrays.stream("Other simple reductions are max and min that return the largest or smallest value.".split("[\\P{L}]+")).
                filter(s -> s.startsWith("r"))//.findFirst();
                        .findAny();

        System.out.println(max.orElse("none found"));

        System.out.println(r.orElse("r not found"));

        Locale[] availableLocales = Locale.getAvailableLocales();
        Map<String, List<Locale>> stringListMap = Arrays.stream(availableLocales).collect(Collectors.groupingBy(Locale::getCountry));
        stringListMap.forEach((country, localList) -> System.out.println("Country :" + country + "-->" + localList));
    }

}
