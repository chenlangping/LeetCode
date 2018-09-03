package com.medium.sortColors;

public class Solution {
    public void sortColors(int[] nums) {
        //把三种颜色记下来就行了
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                num1++;
            } else if (1 == nums[i]) {
                num2++;
            } else {
                num3++;
            }
        }

        //然后把数组搞一下就行了
        for (int i = 0; i < num1; i++) {
            nums[i] = 0;
        }

        for (int i = num1; i < num1 + num2; i++) {
            nums[i] = 1;
        }

        for (int i = num1 + num2; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}