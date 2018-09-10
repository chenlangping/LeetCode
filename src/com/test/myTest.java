package com.test;

import com.medium.findFirstAndLastPositionOfElementinSortedArray.Solution;

import java.util.Arrays;

public class myTest {

    public static void main(String[] args) {
        com.medium.findFirstAndLastPositionOfElementinSortedArray.Solution solution = new Solution();
        int nums[] = {2, 2};
        int target = 2;
        int[] result = new int[2];
        result = solution.searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }


}
