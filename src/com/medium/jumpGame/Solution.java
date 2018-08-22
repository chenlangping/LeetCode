package com.medium.jumpGame;

public class Solution {

    public boolean canJump(int[] nums) {
        boolean result = true;
        int i = nums.length - 1;

        //只有一个数字 不用判断
        if (nums.length == 1) {
            return true;
        }

        //第一个数字是0直接跳过，是不可能到达末尾的
        if (0 == nums[0]) {
            return false;
        }

        //从最后第二个数开始(最后一个数是几都无所谓)
        while (i >= 0) {
            i = canJump(nums, i);
            if (i == -1) {
                result = false;
                break;
            } else if (i == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    //判断end之前的位置能否到达下标为end的位置，如果能就返回该下标
    public int canJump(int[] nums, int end) {
        for (int i = end - 1; i >= 0; i--) {
            if (end - i <= nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {3,2,1,0,4};
        //int[] nums = {2, 3, 1, 1, 4};
        //int[] nums = {1, 2};
        //int[] nums = {0, 2, 3};
        int[] nums = {0};
        System.out.println(solution.canJump(nums));
    }

}
