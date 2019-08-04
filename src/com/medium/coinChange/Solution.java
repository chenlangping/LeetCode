package com.medium.coinChange;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(solution.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount];
        return helper(coins, amount, dp);
        //System.out.println(Arrays.toString(dp));
    }

    private int helper(int[] coins, int left, int[] dp) {
        if (left < 0) {
            return -1;
        }
        if (left == 0) {
            //found the answer
            return 0;
        }
        if (dp[left - 1] != 0) {
            return dp[left - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = helper(coins, left - coin, dp);
            if (tmp >= 0) {
                if (tmp < min) {
                    min = tmp + 1;
                }
            }
        }
        dp[left - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return dp[left - 1];
    }
}
