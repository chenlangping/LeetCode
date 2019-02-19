package com.hard.interleavingString;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        //长度都不同，肯定不是
        if (s3.length() != m + n) {
            return false;
        }
        boolean dp[][] = new boolean[m + 1][n + 1];

        //初始化
        dp[0][0] = true;

        //初始化第一列
        for (int row = 1; row <= m; row++) {
            dp[row][0] = dp[row - 1][0] && (s1.charAt(row - 1) == s3.charAt(row - 1));
            if (!dp[row][0]) {
                break;
            }
        }

        //初始化第一行
        for (int col = 1; col <= n; col++) {
            dp[0][col] = dp[0][col - 1] && (s2.charAt(col - 1) == s3.charAt(col - 1));
            if (!dp[0][col]) {
                break;
            }
        }

        //填充剩余的
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                dp[row][col] = (dp[row - 1][col] && s1.charAt(row - 1) == s3.charAt(row + col - 1))
                        || (dp[row][col - 1] && s2.charAt(col - 1) == s3.charAt(row + col - 1));

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
