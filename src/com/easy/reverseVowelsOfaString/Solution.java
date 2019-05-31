package com.easy.reverseVowelsOfaString;

/**
 * @author chenlangping
 * @date 2019-05-31
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "race car";
        System.out.println(solution.reverseVowels(s));
    }

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        final String vowels = "aeiouAEIOU";
        int j = s.length() - 1;
        for (int i = 0; i < j; i++) {
            if (vowels.indexOf(c[i]) > -1) {
                for (; j >= 0; j--) {
                    if (vowels.indexOf(c[j]) > -1) {
                        char tmp = c[i];
                        c[i] = c[j];
                        c[j] = tmp;
                        j--;
                        break;
                    }
                }
            }
        }

        return String.valueOf(c);
    }

}
