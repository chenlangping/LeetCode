package com.util;


import com.medium.sortColors.*;

import java.util.Arrays;


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] matrix = {2,0,2,1,1,0};
        solution.sortColors(matrix);
        for(int i = 0;i<matrix.length;i++){
            System.out.print(matrix[i]);
        }
    }
}
