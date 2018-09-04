package com.util;


import com.medium.subsets.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = new ArrayList<>();
        int []nums = {1,2,3};
        result = solution.subsets(nums);
        for(int i = 0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
