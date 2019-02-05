package com.medium.simplifyPath;

import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            //利用 "/"作为分隔符来分割
            if (dir.equals("..") && !stack.isEmpty()) {
                //如果是退回到上一级且栈中有东西，那么弹出
                stack.pop();
            } else if (!skip.contains(dir)) {
                //判断下，如果不是本层或者没内容，那么就加入
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            //还原操作
            sb.insert(0, dir);
            sb.insert(0, "/");

        }
        return sb.toString().isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/home//foo/";
        System.out.println(solution.simplifyPath(path));
    }
}
