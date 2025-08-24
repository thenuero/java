package com.nikhiltripathy.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 24/08/2025 at 07:07
 * Author: theneuro
 */

//https://www.geeksforgeeks.org/dsa/write-a-c-program-to-print-all-permutations-of-a-given-string/

public class StringPermutation {
    public static void main(String[] args) {
        String inputString = null;
        System.out.println("Enter the string");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputString = br.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        List<String> permutations = getPermutations(inputString);
        if (!permutations.isEmpty()) {
            permutations.forEach(System.out::println);
        }
    }

    private static List<String> getPermutations(String inputString) {
        if (inputString == null) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuffer str = new StringBuffer(inputString);
        permutationReccur(0, str, ans);
        Collections.sort(ans);

        return ans;
    }

    private static void permutationReccur(int idx, StringBuffer str, List<String> ans) {

        if (idx == str.length()) {
            ans.add(new String(str));
            return;
        }

        for (int i=idx;i<str.length();i++) {
            swap(str, idx, i);
            permutationReccur(idx+1, str, ans);
            swap(str, i, idx);
        }
    }

    private static void swap (StringBuffer str, int from, int to) {
        char temp = str.charAt(from);
        str.setCharAt(from, str.charAt(to));
        str.setCharAt(to, temp);
    }
}
