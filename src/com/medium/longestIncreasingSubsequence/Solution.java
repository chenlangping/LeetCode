package com.medium.longestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            int i = 0, j = length;
            while (i != j) {
                int m = (i + j) / 2;
                if (dp[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            dp[i] = num;
            if (i == length) {
                //如果目前的这个数是当前的递增数列最后一个
                length++;
            }
            for (int k = 0; k < nums.length; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18, 9, 13, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
