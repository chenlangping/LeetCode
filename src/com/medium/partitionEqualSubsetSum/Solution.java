package com.medium.partitionEqualSubsetSum;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int res = sum / 2;
        boolean[] dp = new boolean[res + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = res; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[res];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }
}