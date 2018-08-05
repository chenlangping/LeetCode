package com.medium.setMatrixZeroes;
import com.structure.Matrix.Matrix;


public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length ==0 ) return;
        int rows = matrix.length;//行数
        int columns = matrix[0].length;//列数
        boolean row[] = new boolean [rows];
        boolean column[] = new boolean [columns];
        for(int i=0;i<rows;i++){
            for(int j =0 ; j<columns;j++){
                if(0 == matrix[i][j]){
                    //记录下ij的位置，但是先不改
                    row[i]=true;
                    column[j]=true;
                }
            }
        }

        //开始修改
        for(int i=0;i<rows;i++){
            if(row[i]){
                setRowZero(matrix,i);
            }
        }
        for(int j=0;j<columns;j++){
            if(column[j]){
                setColumnZero(matrix,j);
            }
        }
    }

    private void setColumnZero(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    private void setRowZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][]matrix = {
                    {0,1,2,0},
                    {3,4,5,2},
                    {1,3,1,5},
                    };
        solution.setZeroes(matrix);
        new Matrix().print(matrix);
    }
}
