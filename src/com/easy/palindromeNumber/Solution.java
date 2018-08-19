package com.easy.palindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        try {
            if (x == 0) {
                return true;
            } else if (x < 0) {
                return false;
            } else {
                String num = String.valueOf(x);
                String mnum = new StringBuilder(num).reverse().toString();
                if (num.equals(mnum)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPalindrome2(int x) {
        int num = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x < 10) return true;
        while (num < x) {
            num = x % 10 + num * 10;
            x = x / 10;
        }
        if (x == num || x == num / 10) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 12521;
        System.out.print(solution.isPalindrome2(x));
    }


}
