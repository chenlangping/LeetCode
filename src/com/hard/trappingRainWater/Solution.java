package com.hard.trappingRainWater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int trap(int[] height) {
        int result = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int left_max = 0;
            int right_max = 0;


        }
        return result;
    }

    public int findHighest(int[] height, int start) {
        while (height.length > start + 1) {
            if (height[start + 1] >= height[start]) {
                start++;
            } else {
                return start;
            }
        }
        return -1;
    }

    public int calculateTwoColumn(int[] height, int start, int end) {
        int wid = end - start - 1;
        int high = Math.min(height[start], height[end]);
        int exist = 0;
        for (int i = start + 1; i < end; i++) {
            if(high>=height[i]){
                exist += height[i];
            }else {
                exist+=high;
            }
        }
        System.out.println("wid=" + wid);
        System.out.println("high=" + high);
        System.out.println("exist=" + exist);
        return wid * high - exist;
    }

    public int trap2(int[] height) {
        int result = 0;
        int size = height.length;
        int left = 0;
        int right = 0;
        int start = 0;

        //第一步，找到一根局部最高的
        for (int i = 0; i < size - 2; i++) {
            if (height[i]>height[i+1]){
                start = i;
                break;
            }
        }
        System.out.println("start = "+start );
        for (int i = start +1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                //max_left = Math.max(max_left, height[j]);
                if (height[j] > max_left) {
                    max_left = height[j];
                    left = j;
                }
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                //max_right = Math.max(max_right, height[j]);
                if (height[j] > max_right) {
                    max_right = height[j];
                    right = j;
                }
            }

            System.out.println(height[i] + "左边最大的数=" + max_left + "  右边最大的数=" + max_right);
            result += calculateTwoColumn(height, left, right);
            System.out.println("result = "+result);
            i = right;
            System.out.println("i="+i);
            //result += Math.min(max_left, max_right) - height[i];
        }
        return result;
    }

    public int trap3(int[] height) {
        int len = height.length;
        if (0 == len) {
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        int left_max = height[0];
        int right_max = height[len - 1];
        int result = 0;

        //按照从左到右递增的顺序填充数组，并记录填充的大小
        for (int i = 1; i < len; i++) {
            if (height[i] <= left_max) {
                left[i] = left_max;
            } else {
                left_max = height[i];
                left[i] = left_max;
            }
        }
        //按照从右到左递增的顺序填充数组，并记录填充的大小
        for (int i = len - 2; i >= 0; i--) {
            if (height[i] <= right_max) {
                right[i] = right_max;
            } else {
                right_max = height[i];
                right[i] = right_max;
            }
        }

        //计算重叠部分
        for (int i = 0; i < len; i++) {
            result += Math.min(left[i] - height[i], right[i] - height[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 1, 0, 2, 1};
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 6, 7, 8, 4, 5, 6, 0};
        //int[] height = {5, 4, 3, 4, 5, 3, 2};
        //int[] height = {3, 2, 1, 2, 1, 6, 7, 8, 4, 5, 6, 0};
        //int[] height = {4, 2, 1, 3, 1, 6, 7, 8, 4, 5, 6};

        System.out.println(solution.trap2(height));

        System.out.println("正确答案：" + solution.trap3(height));
    }
}