package com.easy.twosum;

import java.util.Arrays;
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0 ;i<nums.length;i++){
            for (int j = i+1 ;j<nums.length ; j ++){
                if (target == (nums[i]+nums[j])){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}