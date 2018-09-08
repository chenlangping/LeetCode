package com.medium.searchinRotatedSortedArrayII;

public class Solution {
    public boolean search(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        int mid;
        while (big >= small) {
            mid = (big + small) >> 1;
            if (nums[mid] == target) {
                return true;
            }else if(nums[big] == nums[small] && nums[small] == nums[mid]){
                //如果三者在同一条直线上
                small++;
            }else if (nums[mid] >= nums[small]) {
                //此时左半部分一定是非递减的
                if (target < nums[mid] && target >= nums[small]) {
                    big = mid - 1;
                } else {
                    small = mid + 1;
                }
            } else {
                //此时在右半部分是非递减的
                if (target > nums[mid] && target <= nums[big]) {
                    small = mid + 1;
                } else {
                    big = mid - 1;
                }
            }

        }
        return false;


    }
}
