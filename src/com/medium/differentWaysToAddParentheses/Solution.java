package com.medium.differentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        boolean hasOperator = false;
        //用来记录当前的String中是否有运算符，如果没有就说明这个String是一个单纯的数字
        List<Integer> result = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if (0 == input.length()) {
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                hasOperator = true;
                //左边的n个数
                left = diffWaysToCompute(input.substring(0, i));
                //右边的n个数
                right = diffWaysToCompute(input.substring(i + 1));

                //根据它们的符号进行相应的操作
                if (input.charAt(i) == '+') {
                    for (int j = 0; j < left.size(); j++) {
                        for (int k = 0; k < right.size(); k++) {
                            result.add(left.get(j) + right.get(k));
                        }
                    }
                } else if (input.charAt(i) == '-') {
                    for (int j = 0; j < left.size(); j++) {
                        for (int k = 0; k < right.size(); k++) {
                            result.add(left.get(j) - right.get(k));
                        }
                    }
                } else {
                    for (int j = 0; j < left.size(); j++) {
                        for (int k = 0; k < right.size(); k++) {
                            result.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }

        if (!hasOperator) {
            //纯数字，返回
            result.add(Integer.valueOf(input));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "1";
        System.out.println(solution.diffWaysToCompute(input));
    }
}
