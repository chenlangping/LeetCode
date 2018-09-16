package com.hard.largestRectangleInHistogram;

import java.util.Arrays;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0 || heights == null) {
            return 0;
        }
        int maxArea = heights[0];
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        //0左边的是-1
        left[0] = -1;
        //最右边的那根柱子的右边就是数组的长度
        left[heights.length - 1] = heights.length;
        //为每一个柱子找到它左边的离它最近的比它短的柱子
        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j--;
            }
            left[i] = j;
        }
        //为每一个柱子找到它右边的离它最近的比它短的柱子
        for (int i = heights.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < heights.length && heights[j] >= heights[i]) {
                j++;
            }
            right[i] = j;
        }
        //此时已经算出来每条柱子最左边和最右边的了
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));

        //计算面积
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
}
