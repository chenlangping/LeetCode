package com.easy.reverseString;

import java.util.Arrays;

/**
 * @author chenlangping
 * @date 2019-05-26
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = "".toCharArray();
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < (s.length / 2); i++) {
            tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }
}
