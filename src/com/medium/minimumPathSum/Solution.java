package com.medium.minimumPathSum;


public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        //最左边的一列
        for (int i = 1; i < grid.length; i++) {
            result[i][0] = grid[i][0] + result[i - 1][0];
        }

        //最上面的一行
        for (int j = 1; j < grid[0].length; j++) {
            result[0][j] = grid[0][j] + result[0][j - 1];
        }

        //com.structure.Matrix.Matrix.print(result);

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                result[i][j] = grid[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
            }
        }
        //com.structure.Matrix.Matrix.print(result);
        return result[grid.length - 1][grid[0].length - 1];
    }
}
