package com.medium.subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        recursion(result, temp, 0, nums);
        return result;
    }

    public void recursion(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        if (!result.contains(new ArrayList<>(temp))) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            recursion(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public void recursion2(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        if (start <= nums.length) {
            result.add(temp);
        }
        int i = start;
        while (i < nums.length) {
            temp.add(nums[i]);
            recursion2(result, new ArrayList<>(temp), i + 1, nums);
            temp.remove(temp.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return;
    }
}
