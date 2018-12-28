package com.easy.validAnagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            //长度都不相同还怎么可能是
            return false;
        }
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "";
        String t = "";
        System.out.println(solution.isAnagram(s, t));
    }
}
