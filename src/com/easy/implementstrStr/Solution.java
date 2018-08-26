package com.easy.implementstrStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || null == needle) {
            return 0;
        }

        //最多循环haystack.length() - needle.length()次
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int now = i; //记录目前的haystack中的索引
            int count = 0; //匹配上的个数
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(now) != needle.charAt(j)) {
                    break;
                } else {
                    count++;
                    now++;
                }
                if (count == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(solution.strStr(haystack,needle));
        System.out.println(haystack.indexOf(needle));
    }


}
