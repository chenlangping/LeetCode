package com.hard.removeDuplicateLetters;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chenlangping
 * @date 2019-05-24
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters2("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        int position = 0;
        HashMap<Integer, Character> result = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.indexOf(c) != -1) {
                //存在这个字符，那么先在position之后找有没有它的位子
                for (int i = position; i < s.length(); i++) {
                    if (s.charAt(i) == c) {
                        position = i;
                        break;
                    }
                }
                //如果后面没找到
                if (s.charAt(position) != c) {
                    position = s.indexOf(c);
                }

                result.put(position, c);
            } else {
                //不存在这个字符，什么都不用做
            }
        }

        for (Map.Entry<Integer, Character> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return "";
    }

    public String removeDuplicateLetters2(String s) {
        Stack<Character> stack = new Stack<>();

        //1.计算每个字母出现的次数
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }

        boolean[] visited = new boolean[26];

        //2. 对每个字母进行处理
        for (char c : arr) {
            count[c - 'a']--;

            //已经处理过这个字符了，无需处理
            if (visited[c - 'a']) {
                continue;
            }

            //3. 如果顶端的那个字母比现在的这个小，如堆栈的顶端是c，而目前的是a，且c之后还会出现的话，那这个c我就不要了
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void printStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

}
