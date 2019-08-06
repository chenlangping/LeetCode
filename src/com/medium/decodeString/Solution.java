package com.medium.decodeString;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[b4[F]c]"));
    }

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                if (num > 0) {
                    stack.push(String.valueOf(num));
                    num = 0;
                }
                if (c >= 'a' && c <= 'z') {
                    stack.push(String.valueOf(c));
                } else if (c >= 'A' && c <= 'Z') {
                    stack.push(String.valueOf(c));
                } else {
                    // can only be '[' or ']'
                    if (c == '[') {
                        stack.push(String.valueOf(c));
                    } else {
                        // need to pop
                        StringBuilder tmp = new StringBuilder();
                        while (!stack.isEmpty()) {
                            String temp = stack.pop();
                            if (temp.equals("[")) {
                                break;
                            } else {
                                tmp.insert(0, temp);
                            }
                        }
                        String count = stack.pop();
                        stack.push(helper(count, tmp.toString()));
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.getLast());
            stack.removeLast();
        }
        return res.toString();
    }

    private String helper(String count, String s) {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < Integer.valueOf(count); i++) {
                sb.append(s);
            }
        } catch (NumberFormatException c) {
            System.out.println(count);
        }

        return sb.toString();
    }
}
