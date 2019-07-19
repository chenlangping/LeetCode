package com.medium.minimumSizeSubarraySum;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int s = 11;
        System.out.println(solution.minSubArrayLen(s, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            queue.offer(nums[i]);
            while (sum >= s) {
                if (minLen > queue.size()) {
                    minLen = queue.size();
                }
                if (!queue.isEmpty()) {
                    sum -= queue.poll();
                }

            }

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
