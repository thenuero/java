package com.nikhiltripathy.test;

import java.util.stream.Stream;

/**
 * Created on 10/09/2025 at 12:27
 * Author: theneuro
 * asked in Celigo interview. Variation of LC # 75.
 */

public class SortColors {
    public static void main(String[] args) {
        //sort in rgb order.
        char[] input = new char[]{'r', 'r', 'g','b' ,'b', 'g', 'r', 'r', 'b', 'g'};
        int lo = 0, mid = 0;
        int hi = input.length-1;

        while (mid <= hi) {
            if (input[mid] == 'r') {
                char temp = input[lo];
                input[lo++] = input[mid];
                input[mid++] = temp;
            } else if (input[mid] == 'b') {
                char temp = input[mid];
                // we don't update mid here because we have to re evaluate the element swapped in input[mid...hi].
                input[mid] = input[hi];
                input[hi--] = temp;
            } else {
                mid++;
            }
        }
        Stream.of(input).forEach(System.out::print);
    }
}
