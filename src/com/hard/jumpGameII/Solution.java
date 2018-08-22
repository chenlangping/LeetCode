package com.hard.jumpGameII;

public class Solution {

    public int jump(int[] nums) {
        int result = 0;
        int i = nums.length - 1;
        while (i > 0) {
            i = jumpMax(nums, i);
            result++;
        }
        return result;
    }

    //找到能够跳到的最远的数
    public int jumpMax(int[] nums, int end) {
        int min = -1;
        for (int i = end - 1; i >= 0; i--) {
            if (end - i <= nums[i]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
    }
}