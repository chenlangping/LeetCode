package com.medium.findTheDuplicateNumber;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {1, 5, 4, 2, 3, 2};
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate2(nums));
    }

    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;

    }

    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                break;
            }
        }
        return slow;
    }
}