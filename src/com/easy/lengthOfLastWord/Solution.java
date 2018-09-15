package com.easy.lengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = 0;
        int i = s.length() - 1;
        int j = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
            j++;
        }
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                result = s.length() - i - 1 - j;
                break;
            }
            if (0 == i) {
                result = s.length() - j;
                break;
            }
            i--;
        }
        return result;
    }
}
