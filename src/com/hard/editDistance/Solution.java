package com.hard.editDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int matrix[][] = new int[m + 1][n + 1];

        //初始化
        for (int i = 0; i <= m; i++) {
            matrix[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            matrix[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    int replace = matrix[i - 1][j - 1];
                    int delete = matrix[i][j - 1];
                    int insert = matrix[i - 1][j];
                    if (replace <= delete && replace <= insert) {
                        matrix[i][j] = replace + 1;
                    } else if (delete <= replace && delete <= insert) {
                        matrix[i][j] = delete + 1;
                    } else {
                        matrix[i][j] = insert + 1;
                    }
                }
            }
        }

        return matrix[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solution.minDistance(word1, word2));
    }
}
