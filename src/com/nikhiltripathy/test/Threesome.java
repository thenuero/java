package com.nikhiltripathy.test;

import java.util.*;

public class Threesome {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i=0;i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    //res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left +=1;
                    while (nums[left] == nums[left-1] && left < right) {
                        left +=1;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        threeSum(arr).stream()
                .forEach(System.out::println);
    }
}
