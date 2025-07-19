package com.nikhiltripathy.test;

public class TwoSumTwo {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int res[] = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left;
                res[1] = right;
                return res;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int res[] = twoSum(arr,9);
        for(int n : res) {
            System.out.print(n);
        }
    }
}
