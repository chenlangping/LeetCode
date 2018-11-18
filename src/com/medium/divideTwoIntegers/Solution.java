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

    public int divide3(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend > 0 && divisor > 0) {
            return divideHelper(-dividend, -divisor);
        } else if (dividend > 0) {
            return -divideHelper(-dividend, divisor);
        } else if (divisor > 0) {
            return -divideHelper(dividend, -divisor);
        } else {
            return divideHelper(dividend, divisor);
        }
    }

    private int divideHelper(int dividend, int divisor) {
        //首先处理被除数小于除数的问题
        if (divisor < dividend) {
            return 0;
        }
        //得到可以除的最大的
        int cur = 0, res = 0;
        while ((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) {
            cur++;
        }
        res = dividend - (divisor << cur - 1);
        if (res > divisor) {
            return 1 << cur - 1;
        }
        return (1 << cur - 1) + divide3(res, divisor);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide3(30001, 3));
    }
}
