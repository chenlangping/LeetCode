package com.medium.maximumProductSubarray;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-3, -4};
        System.out.println(solution.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tmp * nums[i], min * nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}
