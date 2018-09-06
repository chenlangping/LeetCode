package com.medium.removeduplicatesfromsortedarrayII;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int number : nums) {
            if (i < 2 || number > nums[i - 2]) {
                nums[i] = number;
                i++;
            }
        }
        return i;
    }
}
