package com.easy.validPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] a = new char[s.length()];
        int len = s.length();
        if (0 == len) {
            return true;
        }
        int index = 0;
        int charLen = 0;
        //第一步，先去除除了字母数字以外的字符，并把所有的大写转成小写
        while (index < len) {
            if (isLetter(s.charAt(index)) || isNumber(s.charAt(index))) {
                a[charLen++] = Character.toLowerCase(s.charAt(index));
            }
            index++;
        }
        //第二步，回文判断
        for (int i = 0; i < charLen / 2; i++) {
            if (a[i] != a[charLen - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否是字母
     *
     * @param a
     * @return true = 是字母
     */
    public static boolean isLetter(char a) {
        if (0 <= a - 'a' && 26 > a - 'a') {
            return true;
        }
        if (0 <= a - 'A' && 26 > a - 'A') {
            return true;
        }
        return false;
    }

    /**
     * 判断所给字符是否是0-9这十个数字
     *
     * @param num 所给字符
     * @return true = 是数字 false = 不是数字
     */
    public static boolean isNumber(char num) {
        if ((0 <= num - '0') && (10 > num - '0')) {
            return true;
        }
        return false;
    }

}
