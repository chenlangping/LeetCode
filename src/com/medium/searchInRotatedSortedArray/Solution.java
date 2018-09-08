package com.medium.searchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        int mid;

        while (big >= small) {
            //除以2用移位操作
            mid = (big + small) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[small] <= nums[mid]) {
                //此时左半部分一定是递增的，注意等号的重要性，因为除以二可能会"向前移"
                if (target < nums[mid] && target >= nums[small]) {
                    big = mid - 1;
                } else {
                    small = mid + 1;
                }
            } else {
                //此时在mid的右边是递增的
                if (target > nums[mid] && target <= nums[big]) {
                    small = mid + 1;
                } else {
                    big = mid - 1;
                }
            }

        }
        return -1;


    }

    public int search2(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        //第一步利用二分法找到最小的那个数
        while (small < big) {
            //除以2用移位操作
            int mid = (small + big) >> 1;
            if (nums[mid] > nums[big]) {
                small = mid + 1;
            } else {
                big = mid;
            }
        }
        //此时的small是数组中最小的那个数的下标

        //第二步将找到的最小的那个数视为"起点",进行正常的二分法查找
        int start = small;
        small = 0;
        big = nums.length - 1;
        //正常操作
        while (small <= big) {
            int mid = (small + big) >> 1;
            int realMid = (mid + start) % nums.length;
            if (nums[realMid] == target) {
                return realMid;
            }
            if (nums[realMid] < target) {
                small = mid + 1;
            } else {
                big = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(solution.search2(nums, target));
    }
}