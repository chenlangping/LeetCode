package com.medium.longestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if (0 == s.length()) {
            return "";
        }
        if (1 == s.length()) {
            return s;
        }
        String result = String.valueOf(s.charAt(0));
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            int j = s.length() - 1;
            while (j > i) {
                if (s.charAt(i) == s.charAt(j)) {
                    String sub = s.substring(i, j + 1);
                    if (isPalindrome(sub) && sub.length() > maxLength) {
                        maxLength = sub.length();
                        result = sub;
                        break;
                    }
                }
                j--;
            }
        }
        return result;
    }

    /**
     * 给定字符串，判定其是不是回文字符串
     *
     * @param s 需要判断的字符串
     * @return true = 是回文
     */
    public static boolean isPalindrome(String s) {
        if (0 == s.length()) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    private int lo, maxLen;

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            //考虑回文是奇数的情况
            extendPalindrome(s, i, i);
            //考虑回文是偶数的情况
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        //j和k是回文串的中心位置，它们可能重合
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}