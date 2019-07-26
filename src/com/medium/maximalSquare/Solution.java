package com.medium.maximalSquare;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(solution.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int sideLength = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        //init
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = 0;
        }

        //dynamic
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int left = dp[i][j - 1];
                    int up = dp[i - 1][j];
                    int leftUp = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(left, Math.min(up, leftUp)) + 1;
                    sideLength = Math.max(sideLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return (int) Math.pow(sideLength, 2);
    }
}
