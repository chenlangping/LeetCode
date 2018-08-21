package com.medium.rotateImage;

import com.structure.Matrix.Matrix;

public class Solution {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp = 0;

        //第一步，对角线交换
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //第二步，按照最中间的一列进行镜像交换
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }

    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++)
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix);
        Matrix.print(matrix);
    }

}
