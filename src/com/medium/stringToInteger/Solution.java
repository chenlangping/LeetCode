package com.medium.stringToInteger;

public class Solution {
    public int myAtoi(String str) {
        //result记录结果
        int result = 0;
        //numsofZero 记录字符串最开始的0的个数
        int numsofZero = 0;
        //i 用来记录位置
        int i = 0;
        //判断数字的正负，和有没有带+-符号
        boolean nagative = false;
        boolean hasSign = false;

        //如果长度是0,不用判断
        if (0 == str.length()) {
            return 0;
        }

        //去除开头的空格
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                numsofZero++;
            } else {
                break;
            }
            i++;
        }

        //如果整个字符串全是空
        if (numsofZero == str.length()) {
            return 0;
        }

        //判断第一个是不是'+'或者'-'
        if ('+' == str.charAt(numsofZero)) {
            nagative = false;
            hasSign = true;
        } else if ('-' == str.charAt(numsofZero)) {
            nagative = true;
            hasSign = true;
        } else if (!isNumber(str.charAt(numsofZero))) {
            //不是数字且不是加减号
            return 0;
        }

        //此时确保整个字符串一定是去除开头的空格之后，由数字或者正负号开始的

        if (hasSign) {
            //如果有符号位，那么从下一位开始算
            i = numsofZero + 1;
        } else {
            //没有符号位，直接开始算
            i = numsofZero;
        }
        if (!nagative) {
            //是正数
            while (i < str.length() && isNumber(str.charAt(i))) {
                if (result == Integer.MAX_VALUE / 10 && charToInt(str.charAt(i)) > 7) {
                    return Integer.MAX_VALUE;
                } else if (result > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
                result = result * 10 + charToInt(str.charAt(i));
                i++;
            }
        } else {
            //是负数
            while (i < str.length() && isNumber(str.charAt(i))) {
                if (result == Integer.MIN_VALUE / 10 && charToInt(str.charAt(i)) > 8) {
                    return Integer.MIN_VALUE;
                } else if (result < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 - charToInt(str.charAt(i));
                i++;
            }
        }
        return result;
    }

    /**
     * char转int
     *
     * @param num 需要转换的字符
     * @return 字符对应的int，如果不是0-9之间的字符会回复0
     */
    public static int charToInt(char num) {
        if (isNumber(num)) {
            return num - '0';
        }
        return 0;
    }

    /**
     * 判断所给字符是否是0-9这十个数字
     *
     * @param num 所给字符
     * @return true = 是数字 false = 不是数字
     */
    public static boolean isNumber(char num) {
        if ((0 <= num - '0') && (10 > num - '0')) {
            return true;
        }
        return false;
    }
}
