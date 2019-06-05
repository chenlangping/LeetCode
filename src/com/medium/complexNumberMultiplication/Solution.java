package com.medium.complexNumberMultiplication;

/**
 * @author chenlangping
 * @date 2019-06-05
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "0+-1i";
        String b = "0+-1i";
        System.out.println(solution.complexNumberMultiply(a, b));
    }

    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int a1 = Integer.valueOf(as[0]);
        int b1 = Integer.valueOf(bs[0]);
        int a2 = Integer.valueOf(as[1].substring(0, as[1].length() - 1));
        int b2 = Integer.valueOf(bs[1].substring(0, bs[1].length() - 1));

        int c = a1 * b1 - a2 * b2;
        String tmp = (a1 * b2 + a2 * b1) + "i";

        return c + "+" + tmp;
    }
}
