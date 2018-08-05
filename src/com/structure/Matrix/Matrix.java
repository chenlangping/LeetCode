package com.structure.Matrix;

public class Matrix {

    public void print(int[][] matrix){
        int rows = matrix.length;//行数
        int columns = matrix[0].length;//列数
        for(int i=0;i<rows;i++){
            for(int j =0 ; j<columns;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
