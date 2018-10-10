package com.medium.kthLargestElementInAnArray;

import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, nums.length);
    }

    private int findKthLargest(int[] nums, int k, int length) {
        if (length == 1) {
            return nums[0];
        }
        int i;
        int j = 0;
        int l = 0;
        int[] small = new int[length];
        int[] big = new int[length];
        //基准使用随机数来确定
        int pivot = (int) ((length - 1) * Math.random());
        for (i = 0; i < length; i++) {
            //需要排除掉下标为pivot的本身，不需要排除掉值相等的数
            if (i == pivot) {
                continue;
            }
            //这里格外注意，其实把和nums[pivot]值相等的数归并到哪一边都无所谓
            if (nums[i] < nums[pivot]) {
                small[j++] = nums[i];
            } else {
                big[l++] = nums[i];
            }
        }
        if (k == l + 1) {
            return nums[pivot];
        } else if (k > l + 1) {
            //在pivot左边找
            return findKthLargest(small, k - l - 1, j);
        } else {
            //在pivot右边找
            return findKthLargest(big, k, l);
        }
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
