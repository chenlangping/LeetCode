package com.medium.uniquePathsII;

import com.structure.Matrix.Matrix;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //特殊情况判断
        if (0 == obstacleGrid.length) {
            return 0;
        }
        //赋予初值，需要注意如果遇到障碍，后面的就不用赋初值了(因为根本到不了)
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                result[i][0] = 1;
            }
        }

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                result[0][j] = 1;
            }
        }

        //“递归”求解
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (1 == obstacleGrid[i][j]) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
