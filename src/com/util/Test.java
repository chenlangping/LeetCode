package com.util;


import com.medium.search2DMatrix.Solution;
import com.structure.Matrix.Matrix;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(solution.searchMatrix(matrix,3));
    }
}
