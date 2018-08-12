package com.medium.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        //getResult(lists,new ArrayList<>(),target,candidates,0);
        getAllResults(lists,new ArrayList<>(),target,candidates);
        return lists;
    }

    public void getAllResults(List<List<Integer>> lists , List<Integer> temp, int target , int []candidates){
        if(target == 0){
            //找到一个解
            //lists.add(new ArrayList<>(temp));
            //如果想找到不重复的解，用它
            lists.add(temp);
            return;
        }else if (target < 0){
            //无解，只要不把temp放进去即可
            return;
        }else {
            //递归查找
            for(int i = 0;i<candidates.length;i++){
                temp.add(candidates[i]);
                getAllResults(lists,temp,target-candidates[i],candidates);
                temp.remove(temp.size()-1);
            }
        }
    }

    private void getResult(List<List<Integer>> lists,List<Integer> item,int target,  int[] candidates, int start) {

        if (target < 0) return;
        if (target == 0) {
            lists.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //加上下面这句对结果没有影响，但会减少很多次循环，因为同一个数字可以复用（每次从i开始），所以重复数字就没有意义了
            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            item.add(candidates[i]);
            getResult(lists,item, target - candidates[i],  candidates, i);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] candidates = {2,3};
        int target = 5;
        List<List<Integer>> lists = solution.combinationSum(candidates,target);
        System.out.println(lists);
    }
}