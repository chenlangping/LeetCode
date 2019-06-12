package com.hard.nonNegativeIntegersWithoutConsecutiveOnes;

public class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            if (hasConsecutiveOnes(i)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean hasConsecutiveOnes(int num) {
        int i = 31;
        while (i > 0) {
            if ((num & (1 << i)) != 0 && (num & (1 << (i - 1))) != 0)
                return false;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findIntegers(5));
    }
}
