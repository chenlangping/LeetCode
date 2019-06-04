package com.easy.stringCompression;

import java.util.Arrays;

/**
 * @author chenlangping
 * @date 2019-06-04
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaaab";
        char[] chars = s.toCharArray();
        int result = solution.compress(chars);
        System.out.println(result);
        System.out.println(Arrays.toString(chars));
    }

    public int compress(char[] chars) {
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            char tmp = chars[i];
            int count = 0;
            int cur = i;
            while (cur < chars.length) {
                if (tmp == chars[cur]) {
                    count++;
                    cur++;
                } else {
                    break;
                }
            }

            if (1 == count) {
                chars[pos] = tmp;
                pos++;
            } else {
                chars[pos] = tmp;
                pos++;
                char[] num = String.valueOf(count).toCharArray();
                for (char a : num) {
                    chars[pos] = a;
                    pos++;
                }
            }

            i = cur - 1;
        }
        return pos;
    }
}
