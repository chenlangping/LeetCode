package com.easy.intersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1 = new HashSet<>();
        Set<Integer> num2 = new HashSet<>();
        for (int i : nums1) {
            num1.add(i);
        }
        for (int i : nums2) {
            if (num1.contains(i)) {
                num2.add(i);
            }
        }
        int[] res = new int[num2.size()];
        int j = 0;
        for (int i : num2) {
            res[j++] = i;
        }
        return res;
    }
}
