package com.hard.nonNegativeIntegersWithoutConsecutiveOnes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.judge();
    }

    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int result = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') {
                break;
            }
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') {
                result -= b[i];
            }
        }
        return result;
    }

    private boolean check(int num) {
        int i = 31;
        while (i > 0) {
            if ((num & (1 << i)) != 0 && (num & (1 << (i - 1))) != 0) {
                return false;
            }
            i--;
        }
        return true;
    }

    private void judge() {
        int[] index = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] res = new int[10];

        for (int i = 0; i < index.length; i++) {
            int count = 0;
            for (int j = (int) Math.pow(2, i); j < Math.pow(2, i + 1); j++) {

                if (check(j)) {
                    count++;
                }
            }
            res[i] = count;
        }
        System.out.println(Arrays.toString(res));

        System.out.println(Integer.toBinaryString(30));
    }
}
