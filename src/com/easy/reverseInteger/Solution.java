package com.easy.reverseInteger;

public class Solution {
    public int reverse(int x) {
        try {
            if (x == 0) {
                return 0;
            } else if (x < 0) {
                //如果是负数
                x = (-1) * x;
                String num = String.valueOf(x);
                String mnum = new StringBuilder(num).reverse().toString();
                int result = Integer.parseInt(mnum);
                return (-1) * result;
            } else {
                //排除0和负数，只剩下正数
                String num = String.valueOf(x);
                String mnum = new StringBuilder(num).reverse().toString();
                return Integer.parseInt(mnum);
            }
        } catch (Exception e) {
            return 0;
        }

    }

    public int reverse2(int x) {
        int num = 0;
        while (x != 0) {
            int i = x % 10;
            x /= 10;
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && i > 7)) return 0;
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && i < -8)) return 0;
            num = num * 10 + i;
        }
        return num;
    }

    /*
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 123;
        System.out.println(solution.reverse(x));
    }
    */
}
