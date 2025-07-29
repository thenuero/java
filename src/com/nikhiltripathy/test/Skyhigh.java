package com.nikhiltripathy.test;

import java.util.stream.DoubleStream;

public class Skyhigh {

    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k =3;
        int[] answer = rotateArray(arr, k);

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    private static int[] rotateArray (int[] arr, int k) {
        int start = 0, end = k;
        int swap =0;
        while (start < k) {
           swap = arr[start];
           arr[start++] = arr[end];
           arr[end++] = swap;
        }
        System.out.println(start);
        System.out.println(end);
//        for (int i=start; i<k; start++) {
//
//        }
        return arr;
    }
}
