package com.easy.searchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        //二分查找法
        int small = 0;
        int big = nums.length-1;
        int medium = -1;
        while(big>=small){
            medium = (small+big)/2;
            if(target == nums[medium]){
                return medium;
            }else if(target > nums[medium]){
                small = medium+1;
            }else {
                big = medium-1;
            }
        }
        return nums[medium]>target?medium:medium+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums = {1,3,5,6};
        int target = 0;
        System.out.println(solution.searchInsert(nums,target));
    }
}
