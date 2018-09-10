package com.medium.findFirstAndLastPositionOfElementinSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid = binarySearch(nums, target);
        int[] result = {-1, -1};
        if (-1 == mid) {
            return result;
        } else {
            int left = mid;
            int right = mid;
            result[0] = left;
            result[1] = right;
            while (left >= 1) {
                if (nums[left] == nums[left - 1]) {
                    left--;
                } else {
                    result[0] = left;
                    break;
                }
                //这句至关重要
                result[0] = left;
            }
            while (right < nums.length - 1) {
                if (nums[right] == nums[right + 1]) {
                    right++;
                } else {
                    result[1] = right;
                    break;
                }
                //这句至关重要
                result[1] = right;
            }
            return result;
        }

    }

    /**
     * 二分查找法
     *
     * @param nums   待查找的数组
     * @param target 目标数字
     * @return 对应的下标，不存在返回-1
     */
    public static int binarySearch(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        int mid;
        int result = -1;
        while (big >= small) {
            mid = (big + small) >> 1;
            if (nums[mid] == target) {
                result = mid;
                return result;
            } else if (nums[mid] > target) {
                big = mid - 1;
            } else {
                small = mid + 1;
            }
        }
        return result;
    }

}
