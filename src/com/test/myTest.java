package com.test;

import com.medium.combinationSum.Solution;

import java.util.Arrays;
import java.util.List;

public class myTest {

    public static void main(String[] args) {
        com.medium.combinationSum.Solution solution = new Solution();
        int[] candidates = {2, 3, 5, 1, 2, 3, 4};
        int target = 5;
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists);
    }


}
