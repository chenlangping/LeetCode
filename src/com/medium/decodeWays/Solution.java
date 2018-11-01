package com.medium.decodeWays;

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int num1 = Integer.valueOf(s.substring(i - 1, i));
            int num2 = Integer.valueOf(s.substring(i - 2, i));
            if (num1 >= 1 && num1 <= 9) {
                dp[i] += dp[i - 1];
            }
            if (num2 >= 10 && num2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("12"));
    }
}
