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
}
