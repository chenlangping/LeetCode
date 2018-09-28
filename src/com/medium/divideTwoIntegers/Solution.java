package com.medium.divideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        if (0 == dividend) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend > 0 && divisor > 0) {
            //相当于 10/3
            while (dividend >= 0) {
                dividend -= divisor;
                result++;
            }
            result--;
        } else if (dividend < 0 && divisor > 0) {
            //相当于 -10/3
            while (dividend <= 0) {
                dividend += divisor;
                result--;
            }
            result++;
        } else if (dividend > 0 && divisor < 0) {
            //相当于 10/-3
            while (dividend >= 0) {
                dividend += divisor;
                result--;
            }
            result++;
        } else {
            //相当于 -10/-3
            while (dividend <= 0) {
                dividend -= divisor;
                result++;
            }
            result--;
        }
        return result;
    }

    public int divide2(int dividend, int divisor) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (divisor << i == dividend) {
                return divisor << i;
            } else if (dividend << i < dividend) {

            }
        }
        return result;
    }
}
