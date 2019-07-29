package com.medium.perfectSquares;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(25));
    }

    public int numSquares(int n) {
        if (n < 1) {
            //error input
            return -1;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        if (n == 4) {
            return 1;
        }

        //special situation is done
        //for easy, dp[1] means the number of 1,not 2.
        int[] dp = new int[n + 1];
        dp[0] = 0;  //very important
        dp[1] = 1;  //1 = 1
        dp[2] = 2;  //2 = 1+1
        dp[3] = 3;  //3 = 1+1+1
        dp[4] = 1;  //4 = 4
        for (int i = 5; i <= n; i++) {
            //any integer can use 1+1+1+1.....to compose
            int min = i;
            for (int j = 1; ; j++) {
                if (j * j > i) {
                    break;
                }
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
