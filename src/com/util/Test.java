package com.util;


import com.medium.spiralMatrixII.Solution;
import com.structure.Matrix.Matrix;

public class Test {
    public static void main(String[] args) {
        com.medium.spiralMatrixII.Solution solution = new Solution();
        int n = 3;
        int[][] matrix = new int[n][n];
        matrix = solution.generateMatrix(5);
        new Matrix().print(matrix);
    }
}
