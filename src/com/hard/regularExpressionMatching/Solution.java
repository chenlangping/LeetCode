package com.hard.regularExpressionMatching;

import com.structure.Matrix.Matrix;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        //其实有隐含条件：p的第一个肯定不能是*
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //如果是"." 说明可以匹配任何，直接往下面去即可
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                //两者完全一致，说明可以匹配
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                //最难的一个，如果是"*"，说明可以匹配一个或者0个
                if (p.charAt(j) == '*') {
                    //如果前一个不能匹配上，说明"*"只能是0个
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        //前一个匹配上，所以可以是多个
                        //三个分别是：            a*=a        a*=aa                a*=空
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aaaaaaaaaaaaa", "a*"));
    }
}
