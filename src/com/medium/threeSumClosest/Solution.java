package com.medium.threeSumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minError = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int curSum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - curSum) < Math.abs(minError)) {
                        minError = Math.abs(target - curSum);
                        result = curSum;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {0,0,0};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
