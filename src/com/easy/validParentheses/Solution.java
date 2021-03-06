package com.easy.validParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        int length = s.length();
        if (length % 2 != 0) {
            //奇数个是不可能匹配的
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{')) {
                sb.append(s.charAt(i));
            } else {
                if (0 == sb.length()) {
                    return false;
                } else {
                    //剩下的三个右括号
                    if (s.charAt(i) == ')' && sb.charAt(sb.length() - 1) == '(') {
                        sb.deleteCharAt(sb.length() - 1);
                    } else if (s.charAt(i) == ']' && sb.charAt(sb.length() - 1) == '[') {
                        sb.deleteCharAt(sb.length() - 1);
                    } else if (s.charAt(i) == '}' && sb.charAt(sb.length() - 1) == '{') {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
        if (0 == sb.length()) {
            return true;
        } else return false;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        //String s = "(([]){})";
        //String s = "()[]{}";
        //String s = "(]";
        //String s = "([)]";
        String s = "{[]}";
        boolean result = solution.isValid2(s);
        System.out.print(result);
    }

}
