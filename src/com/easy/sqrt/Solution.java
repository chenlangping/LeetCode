package com.easy.sqrt;

public class Solution {
    public int mySqrt(int x) {
        if (0 == x) {
            return 0;
        }
        int small = 0;
        int big = Integer.MAX_VALUE;
        while (true) {
            int mid = small + ((big - small) >> 1);
            if (mid > x / mid) {
                big = mid - 1;
            } else if (mid + 1 > x / (mid + 1)) {
                return mid;
            } else {
                small = mid + 1;
            }
        }
    }
}
