package com.easy.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        //1.首先建立hashmap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //2.建立映射关系
        //需要注意的是，应该把nums[i]作为key，下标作为value，因为需要根据key来找value
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //3.利用hashmap快速查找
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            //map中包含那个数字且不是那个数字自己
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{i, map.get(temp)};
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        //1.首先建立hashmap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //2.利用hashmap快速查找
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp),i };
            }
            map.put(nums[i],i);
        }
        return null;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

}