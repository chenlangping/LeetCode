package com.easy.majorityElement;

public class Solution {
    public int majorityElement(int[] nums) {
        return getMajorityNumber(nums, 0, nums.length - 1);
    }

    private int getMajorityNumber(int[] nums, int start, int end) {
        int mid = 0;
        if (start == end) {
            return nums[start];
        } else {
            mid = (end - start) >> 1;
            int left = getMajorityNumber(nums, start, start + mid);
            int right = getMajorityNumber(nums, start + mid + 1, end);
            if (left == right) {
                return left;
            } else {
                int leftCount = count(nums, start, start + mid, left);
                int rightCount = count(nums, start + mid, end, right);
                return leftCount > rightCount ? left : right;
            }
        }
    }

    private int count(int[] nums, int start, int end, int num) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(nums));
    }
}