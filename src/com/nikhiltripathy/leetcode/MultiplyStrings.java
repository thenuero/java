package com.nikhiltripathy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2)  {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int num1length = num1.length(), num2length = num2.length();
        if (num1length < num2length)
            return multiply(num2, num1);
        int powerOfTen = 0;
        List<String> multiplicationRes = new ArrayList<>();
        for (int i=num2length-1;i>-1;i--) {
            int digit1 = num2.charAt(i) - '0';
            int coeff = (int) Math.pow(10,powerOfTen++);
            digit1 *= coeff;
            for (int j = num1length-1; j > -1; j--) {
                int digit2 = num1.charAt(j) - '0';
                //We have both the digits now.. multiply it.
                int res = digit1 * digit2;
                multiplicationRes.add(Integer.toString(res));
            }
        }
//At this time we have all the multiplication result..
        multiplicationRes
                .forEach(System.out::println);
        return  "";
    }

    public static void main(String[] args) {
        MultiplyStrings sm = new MultiplyStrings();
        sm.multiply("123", "456");
    }
}



