package com.hard.firstMissingPositive;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        Map map = new HashMap();
        int numOfNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                numOfNegative++;
            } else if (nums[i] < min) {
                min = nums[i];
            }
            map.put(i, nums[i]);
        }
        if (numOfNegative == nums.length) {
            min = 1;
        }

        if (min == 1) {
            while (map.containsValue(min)) {
                min++;
            }
            return min;
        } else return 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {100, -1, 50, 2, 3, 5, 4, 6};
        System.out.println(solution.firstMissingPositive2(nums));
    }
}
