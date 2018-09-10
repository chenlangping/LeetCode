package com.medium.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        getResult(lists, new ArrayList<>(), target, candidates, 0);
        return lists;
    }

    private void getResult(List<List<Integer>> lists, List<Integer> item, int target, int[] candidates, int start) {
        //小于0说明无解了
        if (target < 0) {
            return;
        }
        //找到一组解
        if (target == 0) {
            lists.add(new ArrayList<>(item));
            return;
        }
        //递归查找解
        for (int i = start; i < candidates.length; i++) {
            //查找优化，因为相同的其实没必要，只需要一个就可以了
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            item.add(candidates[i]);
            getResult(lists, item, target - candidates[i], candidates, i);
            item.remove(item.size() - 1);
        }
    }
}