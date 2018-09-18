package com.easy.climbingStairs;

public class Solution {

    /**
     * 用斐波那契数列，结果超时
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (1 == n) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }


}