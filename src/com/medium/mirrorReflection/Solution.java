package com.medium.mirrorReflection;

/**
 * @author chenlangping
 * @date 2019-06-15
 */
public class Solution {
    public int mirrorReflection(int p, int q) {
        if (p == 0) {
            return 2;
        }
        if (q == 0) {
            return 0;
        }

        // 此时保证了肯定是斜着的线

        while (p % 2 == 0 && q % 2 == 0) {
            p = p / 2;
            q = q / 2;
        }
        //p为奇数，q为奇数时，到达接收器1。
        //p为奇数，q为偶数时，到达接收器0。
        //p为偶数，q为奇数时，到达接收器2。
        if (p % 2 == 1) {
            if (q % 2 == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 2;
        }
    }
}
