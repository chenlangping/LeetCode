package com.medium.containerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;    //max为最后返回的最大面积
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int small = height[i] > height[j] ? height[j] : height[i];    //small是数组中值较少的那个
                int square = Math.abs(small * (j - i));
                if (square > max) {
                    max = square;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int wid = end - start;
            if (height[start] < height[end]) {
                max = Math.max(max, wid * height[start]);
                start++;
            } else {
                max = Math.max(max, wid * height[end]);
                end--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea2(height));
    }

}
