package com.util;


import com.medium.minimumPathSum.Solution;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][]nums2 = {
                {1,0,1}
        };
        int [][]nums= {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
            };
        System.out.println(solution.minPathSum(nums2));
    }
}
