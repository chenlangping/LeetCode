package com.medium.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
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

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix3 = {};
        List<Integer> list = new ArrayList<>();
        Solution solution = new Solution();
        list = solution.spiralOrder(matrix2);
        System.out.println(list);
    }
}
