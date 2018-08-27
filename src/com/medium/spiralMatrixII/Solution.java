package com.medium.spiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n;
        int columnBegin = 0;
        int columnEnd = n;
        int cur = n * n;
        int num = 1;
        while (cur > 0) {
            //1.从左向右
            for (int j = rowBegin; j < rowEnd; j++) {
                matrix[columnBegin][j] = num;
                num++;
                cur--;
            }

            //2.从上到下
            for (int i = columnBegin + 1; i < columnEnd; i++) {
                matrix[i][rowEnd - 1] = num;
                num++;
                cur--;
            }

            //3.从右向左
            for (int j = rowEnd - 2; j >= rowBegin; j--) {
                matrix[columnEnd - 1][j] = num;
                num++;
                cur--;
            }

            //4.从下到上
            for (int i = columnEnd - 2; i > columnBegin; i--) {
                matrix[i][rowBegin] = num;
                num++;
                cur--;
            }
            rowBegin++;
            rowEnd--;
            columnBegin++;
            columnEnd--;

        }
        return matrix;
    }
}
