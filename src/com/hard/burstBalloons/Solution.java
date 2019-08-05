package com.hard.burstBalloons;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // init new array
        int[] num = new int[nums.length + 2];
        num[0] = 1;
        num[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            num[i + 1] = nums[i];
        }
        System.out.println(Arrays.toString(num));

        // start dp
        int[][] dp = new int[num.length][num.length];
        for (int i = 2; i < num.length; i++) {
            for (int left = 0; left < num.length - i; left++) {
                int right = left + i;
                for (int j = left + 1; j < right; j++)
                    dp[left][right] = Math.max(dp[left][right], num[left] * num[j] * num[right] + dp[left][j] + dp[j][right]);
            }
        }
        return dp[0][num.length - 1];
    }
}