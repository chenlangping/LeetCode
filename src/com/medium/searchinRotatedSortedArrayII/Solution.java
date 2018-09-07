package com.medium.searchinRotatedSortedArrayII;

public class Solution {
    public boolean search(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        int mid;

        while (big >= small) {
            mid = (big + small) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[small] < nums[mid] || nums[mid] > nums[big]) {
                //此时左半部分一定是非递减的
                if (target < nums[mid] && target >= nums[small]) {
                    big = mid - 1;
                } else {
                    small = mid + 1;
                }
            } else if (nums[mid] < nums[big] || nums[mid] < nums[small]) {
                //此时在右半部分是非递减的
                if (target > nums[mid] && target <= nums[big]) {
                    small = mid + 1;
                } else {
                    big = mid - 1;
                }
            } else {
                small++;
            }

        }
        return false;


    }
}
