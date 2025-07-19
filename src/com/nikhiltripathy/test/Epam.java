package com.nikhiltripathy.test;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Epam {
    //1. Write a program that counts the duplicate words  in a string.
    public static void main(String[] args) {
        String str = "Hello World, Hello Welcome to EPAM";
        str = str.toLowerCase();
        int count =0;
        Set<String> set = new HashSet<>();
        String words[] = str.split(" ");
        for (String word : words) {
            if (!Character.isAlphabetic(word.charAt(word.length()-1))) {
                word = word.substring(0,word.length());
            }
            if (!set.add(word)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
