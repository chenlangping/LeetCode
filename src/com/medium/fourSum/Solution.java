package com.medium.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList();

        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int small = j+1;
                int big = nums.length-1;
                while(big>small){
                    if(nums[i]+nums[j]+nums[small]+nums[big] == target){
                        List temp = new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[small]);
                        temp.add(nums[big]);
                        if(!lists.contains(temp)){
                            lists.add(new ArrayList<>(temp));
                        }
                        small++;
                        big--;
                        while(big > small && nums[small]==nums[small-1]){
                            small++;
                        }
                        while(big > small && nums[big] == nums[big+1]){
                            big--;
                        }
                    }else if (nums[i]+nums[j]+nums[small]+nums[big] < target){
                        small++;
                    }else {
                        big--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] ={-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> lists = solution.fourSum(nums,target);
        System.out.println(lists);
    }
}