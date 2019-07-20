package com.easy.singleNumber;

public class Solution {
    public int singleNumber(int[] nums) {
        //异或操作会留下最后的那一个数
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2, 3, 3, 4, 5, 4, 5};
        System.out.println(solution.singleNumber(nums));
    }
}
