package com.easy.firstUniqueCharacterInaString;

/**
 * @author chenlangping
 * @date 2019-06-01
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        int[] res = helper(s);
        for (int i = 0; i < s.length(); i++) {
            if (1 == res[s.charAt(i) - 'a']) {
                return i;
            }
        }
        return -1;
    }

    private int[] helper(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a'] += 1;
        }
        return res;
    }
}