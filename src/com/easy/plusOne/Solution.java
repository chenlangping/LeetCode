package com.easy.plusOne;

public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        //从最后一位开始
        for (int i = length - 1; i >= 0; i--) {
            //如果不存在进位
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            //如果存在进位
            digits[i] = 0;
        }
        //如果一直进位到第一位，那么需要重新搞一个新的
        int[] newResult = new int[length + 1];
        newResult[0] = 1;
        return newResult;
    }
}