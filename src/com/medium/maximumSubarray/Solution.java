package com.medium.maximumSubarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        //创建一个新数组，该数组存放到目前为止最大的
        int[] maxArray = new int[length];
        maxArray[0] = nums[0];
        int max = maxArray[0];

        for (int i = 1; i < length; i++) {
            maxArray[i] = nums[i] + (maxArray[i - 1] > 0 ? maxArray[i - 1] : 0);
            max = Math.max(max, maxArray[i]);
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray2(nums));
    }
}
