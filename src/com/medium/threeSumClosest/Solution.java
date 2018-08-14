package com.medium.threeSumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minError = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int small = i + 1;
            int big = nums.length - 1;
            while (big > small) {
                int curSum = nums[i] + nums[big] + nums[small];
                if(Math.abs(target - curSum) < minError){
                    minError = Math.abs(target-curSum);
                    result = curSum;

                    //优化操作
                    while(big > small &&nums[small]==nums[small+1]){
                        small++;
                    }
                    while(big > small &&nums[big]==nums[big-1]){
                        big--;
                    }
                }else if(curSum < target){
                    small++;
                }else big--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1,2,5,10,11};
        int target = 12;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
