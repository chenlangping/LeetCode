package com.medium.ZigZagConversion;

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if (0 == len) {
            return "";
        }
        if (numRows < 1) {
            return "";
        }
        if (1 == numRows) {
            return s;
        }
        if (2 == numRows) {
            int i = 0;
            while (i < len) {
                sb.append(s.charAt(i));
                i = i + 2;
            }
            i = 1;
            while (i < len) {
                sb.append(s.charAt(i));
                i = i + 2;
            }
            return sb.toString();
        }
        int group = 2 * numRows - 2;
        int cur;
        //第一行
        for (int j = 0; j < len; j = j + group) {
            sb.append(s.charAt(j));
        }
        for (int i = 1; i < numRows - 1; i++) {
            cur = i * 2;
            for (int j = i; j < len; j = j + cur) {
                cur = group - cur;
                sb.append(s.charAt(j));
            }
        }
        //最后一行
        for (int j = numRows - 1; j < len; j = j + group) {
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
