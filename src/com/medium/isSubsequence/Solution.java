package com.medium.isSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        int curIndexOfS = 0;
        int curIndexOfT = 0;
        while (curIndexOfT < t.length()) {
            if (s.charAt(curIndexOfS) == t.charAt(curIndexOfT)) {
                curIndexOfS++;
                curIndexOfT++;
                if (curIndexOfS == s.length()) {
                    return true;
                }
                continue;
            }
            curIndexOfT++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(solution.isSubsequence(s, t));
    }
}
