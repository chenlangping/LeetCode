package com.structure.Matrix;

public class Matrix {

    /**
     * 打印目标矩阵
     * @param matrix 目标矩阵
     */
    public static void print(int[][] matrix) {
        int rows = matrix.length;//行数
        int columns = matrix[0].length;//列数
        for (int i = 0; i < rows; i++) {
            System.out.print("|\t");
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    /**
     * 将矩阵按照对角线进行交换
     * @param matrix 目标矩阵
     */
    public static void diagonalChange(int[][] matrix) {
        int len = matrix[0].length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
