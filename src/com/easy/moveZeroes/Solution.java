package com.easy.moveZeroes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 0, 3, 12};
        solution.moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
