package com.hard.maximalRectangle;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int cLen = matrix[0].length;
        int rLen = matrix.length;
        int[] h = new int[cLen + 1];
        h[cLen] = 0;
        int max = 0;


        for (int row = 0; row < rLen; row++) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < cLen + 1; i++) {
                if (i < cLen) {
                    if (matrix[row][i] == '1') {
                        h[i] += 1;
                    } else {
                        h[i] = 0;
                    }
                }
                //System.out.println(Arrays.toString(h));
                if (s.isEmpty() || h[s.peek()] <= h[i])
                    s.push(i);
                else {
                    while (!s.isEmpty() && h[i] < h[s.peek()]) {
                        int top = s.pop();
                        int height = h[top];
                        int left;
                        if (s.isEmpty()) {
                            left = 0;
                        } else {
                            left = s.peek() + 1;
                        }
                        int right = i;
                        int area = height * (right - left);
                        if (area > max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
        };
        System.out.println(solution.maximalRectangle(matrix));
    }
}
