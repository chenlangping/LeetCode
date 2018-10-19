package com.hard.longestValidParentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int pos;
        int count = 0;
        int[] array = new int[s.length()];
        Stack<Integer> stack = new Stack();
        //将1设置为匹配上的
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    continue;
                }
                pos = stack.pop();
                array[pos] = 1;
                array[i] = 1;
            }
        }

        //统计数组中连续的1的最多的个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = ")()())";
        System.out.println(solution.longestValidParentheses(s));
    }
}
