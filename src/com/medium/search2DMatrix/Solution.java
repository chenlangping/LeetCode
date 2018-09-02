package com.medium.search2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (0 == row) {
            return false;
        }
        int column = matrix[0].length;
        int small = 0;
        int big = row * column - 1;
        int mid;
        int curRow;
        int curCol;
        while (big >= small) {
            mid = (big + small) / 2;
            curCol = mid % column;
            curRow = (mid - curCol) / column;
            if (target == matrix[curRow][curCol]) {
                return true;
            } else if (target > matrix[curRow][curCol]) {
                small = mid + 1;
            } else {
                big = mid - 1;
            }
        }

        return false;
    }
}
