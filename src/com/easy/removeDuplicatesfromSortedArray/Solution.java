package com.easy.removeDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0 ) return 0;
        int j = 0;
        for (int i = 1 ;i<length;i++){
            if (nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];

            }
        }
        return j + 1;
    }

    /*
    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
    */
}
