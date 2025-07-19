package com.nikhiltripathy.search;

public class BinarySearch {
    public static int binarySearch(int nums[], int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right-left) / 2;
            if(nums[mid] == target) {
                return mid;
            } if (nums[mid] > target) {
                return binarySearch(nums, left, mid - 1, target);
            }
                return binarySearch(nums, mid+1, right, target);

        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1,3};
        System.out.println(binarySearch(nums, 0, nums.length-1, 2));
}
}
