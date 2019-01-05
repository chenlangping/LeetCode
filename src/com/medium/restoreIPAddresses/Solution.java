package com.medium.restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            //最大是255.255.255.255
            return res;
        }
        for (int i = 1; i < 4 && i < s.length() - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < s.length() - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k);
                    if (isValidIPAddress(s1) && isValidIPAddress(s2) && isValidIPAddress(s3) && isValidIPAddress(s4)) {
                        res.add(s1.trim() + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValidIPAddress(String s) {
        if (s.length() >= 4 || (s.charAt(0) == '0' && s.length() > 1)) {
            return false;
        }
        if (Integer.valueOf(s) <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "010010";
        System.out.println(solution.restoreIpAddresses(s));
    }
}
