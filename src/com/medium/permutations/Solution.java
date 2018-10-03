package com.medium.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, new ArrayList<>(), nums);
        return result;
    }

    private void recursion(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    //如果已经存在了，则不需要再遍历了
                    continue;
                }
                tempList.add(nums[i]);
                recursion(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}