package com.medium.combinationSumII;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists= new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        getResult(lists,list,candidates,target,-1);
        return lists;
    }

    public void getResult(List<List<Integer>> lists,List list,int[] candidates, int target,int start){
        if(target < 0){
            return ;
        }else if (0 == target){
            if(!lists.contains(new ArrayList<>(list))){
                lists.add(new ArrayList<>(list));
                return;
            }
            return;
        }else {
            for(int i=start+1;i<candidates.length;i++){
                list.add(candidates[i]);
                getResult(lists,list,candidates,target-candidates[i],i);
                list.remove(list.size()-1);
                if( i<candidates.length-1 && candidates[i] == candidates[i+1] ){
                    i++;
                }
            }
        }








    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] candidates = {2,2,2};
        int target = 2;
        List<List<Integer>> lists = solution.combinationSum2(candidates,target);
        System.out.println(lists);
    }
}


