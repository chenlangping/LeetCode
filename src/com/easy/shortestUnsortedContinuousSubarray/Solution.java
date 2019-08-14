package com.easy.shortestUnsortedContinuousSubarray;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 4, 5, 3};
        System.out.println(solution.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int begin = -1;
        int end = -2;
        int min = nums[n - 1];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[n - 1 - i] > min) {
                begin = n - 1 - i;
            }
        }
        return end - begin + 1;
    }
}