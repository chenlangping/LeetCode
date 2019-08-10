package com.hard.longestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 0, 1};
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int left = 0, right = 0;
            if (map.containsKey(num - 1)) {
                left = map.get(num - 1);
            }
            if (map.containsKey(num + 1)) {
                right = map.get(num + 1);
            }
            int tmp = left + right + 1;
            map.put(num, tmp);
            map.put(num - left, tmp);
            map.put(num + right, tmp);
            res = Math.max(res, tmp);
        }
        return res;
    }
}
