package com.medium.permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        recursion(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void recursion(List<List<Integer>> result, List<Integer> tempList,
                           int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //如果目前的数字已经被用过了，直接下一个数字
            if (used[i]) {
                continue;
            }
            //如果目前的这个数字和之前的一样，且前一个数字没被用过，那么不需要了
            if (i >= 1 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            recursion(result, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1, 2, 2, 2};
        System.out.println(solution.permuteUnique(nums));

    }
}
