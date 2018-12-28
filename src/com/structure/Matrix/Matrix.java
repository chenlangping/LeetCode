package com.structure.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    /**
     * 打印目标矩阵
     *
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
     * 打印char数组
     * @param matrix
     */
    public static void print(char[][] matrix) {
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
     * 打印目标矩阵
     *
     * @param matrix 目标矩阵
     */
    public static void print(boolean[][] matrix) {
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
     *
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

    /**
     * 螺旋打印二维数组
     *
     * @param matrix 要打印的数组
     * @return list内存放打印好的数组
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        if (0 == row) {
            //空数组就返回空
            return list;
        }
        int column = matrix[0].length;
        int count = row * column;

        //初始化四个顶点
        int row1 = 0;
        int column1 = 0;

        int row2 = 0;
        int column2 = column;

        int row3 = row;
        int column3 = column;

        int row4 = row;
        int column4 = 0;
        while (count > 0) {
            //第一趟从左往右
            for (int j = column1; j < column2; j++) {
                //System.out.print("1:");
                //System.out.println(matrix[row1][j]);
                list.add(matrix[row1][j]);
                count--;
            }
            if (0 == count) break;

            //第二趟从上往下
            for (int i = row2 + 1; i < row3; i++) {
                //System.out.print("2:");
                //System.out.println(matrix[i][column2 - 1]);
                list.add(matrix[i][column2 - 1]);
                count--;
            }
            if (0 == count) break;

            //第三趟从右到左
            for (int j = column3 - 2; j >= column4; j--) {
                //System.out.print("3:");
                //System.out.println(matrix[row3 - 1][j]);
                list.add(matrix[row3 - 1][j]);
                count--;

            }
            if (0 == count) break;

            //第四趟从下到上
            for (int i = row4 - 2; i > row1; i--) {
                //System.out.print("4:");
                //System.out.println(matrix[i][column4]);
                list.add(matrix[i][column4]);
                count--;

            }
            if (0 == count) break;

            //移动四个顶点
            row1++;
            column1++;

            row2++;
            column2--;

            row3--;
            column3--;

            row4--;
            column4++;
        }
        return list;
    }
}
