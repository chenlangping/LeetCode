package com.medium.myPow;

public class Solution {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE - 1;
            } else {
                n = -n;
            }
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double x = 2.00000;
        int n = -2;
        System.out.println(solution.myPow(x, n));
    }
}
