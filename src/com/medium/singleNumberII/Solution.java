package com.medium.singleNumberII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenlangping
 * @date 2019-05-10
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 2, 3};
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(10);
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
