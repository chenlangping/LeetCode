package com.medium.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(result, temp, 0, nums);
        return result;
    }

    public void recursion(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            recursion(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
