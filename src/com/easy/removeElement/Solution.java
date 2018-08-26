package com.easy.removeElement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    /*
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums ={0,1,2,2,3,0,4,2};
        System.out.println(solution.removeElement(nums,2));
    }
    */
}
