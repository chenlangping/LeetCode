package com.medium.compareVersionNumbers;


/**
 * @author chenlangping
 * @date 2019-05-30
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String version1 = "1.0.0.0.0";
        String version2 = "1.0.0.0";
        System.out.println(solution.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.min(v1.length, v2.length);

        for (int i = 0; i < len; i++) {
            int a = Integer.valueOf(v1[i]);
            int b = Integer.valueOf(v2[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        if (v1.length == v2.length) {
            return 0;
        } else if (v1.length < v2.length) {
            for (int i = v1.length; i < v2.length; i++) {
                int a = Integer.valueOf(v2[i]);
                if (a > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            for (int i = v2.length; i < v1.length; i++) {
                int a = Integer.valueOf(v1[i]);
                if (a > 0) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
