package com.easy.removeDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }

    /*
    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
    */
}
