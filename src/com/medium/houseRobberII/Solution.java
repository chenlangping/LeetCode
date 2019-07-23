package com.medium.houseRobberII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        // ensure that the length of array is 2 or more
        return Math.max(robHelp(Arrays.copyOfRange(nums, 1, nums.length)), robHelp(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int robHelp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        //init
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if robber do not rob the house
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // robber rob the house
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}