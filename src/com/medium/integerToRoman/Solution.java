package com.medium.integerToRoman;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 10) {
            //只有一位数的时候，注意题设说了从1开始
            return oneNumberToRoman(num);
        } else if (num < 100) {
            //两位数的时候
            return twoNumberToRoman(num);
        } else if (num < 1000) {
            //三位数的时候
            return threeNumberToRoman(num);
        } else {
            //四位数的时候
            return fourNumberToRoman(num);
        }
    }

    public static String oneNumberToRoman(int num) {
        if (1 == num) {
            return "I";
        }
        if (2 == num) {
            return "II";
        }
        if (3 == num) {
            return "III";
        }
        if (4 == num) {
            return "IV";
        }
        if (5 == num) {
            return "V";
        }
        if (6 == num) {
            return "VI";
        }
        if (7 == num) {
            return "VII";
        }
        if (8 == num) {
            return "VIII";
        }
        if (9 == num) {
            return "IX";
        }
        return "";
    }

    public static String twoNumberToRoman(int num) {
        //x是十位数
        int x = num / 10;
        String result = "";
        if (1 == x) {
            result = "X";
        }
        if (2 == x) {
            result = "XX";
        }
        if (3 == x) {
            result = "XXX";
        }
        if (4 == x) {
            result = "XL";
        }
        if (5 == x) {
            result = "L";
        }
        if (6 == x) {
            result = "LX";
        }
        if (7 == x) {
            result = "LXX";
        }
        if (8 == x) {
            result = "LXXX";
        }
        if (9 == x) {
            result = "XC";
        }

        return result + oneNumberToRoman(num % 10);

    }

    public static String threeNumberToRoman(int num) {
        //c是百位数
        int c = num / 100;
        String result = "";
        if (1 == c) {
            result = "C";
        }
        if (2 == c) {
            result = "CC";
        }
        if (3 == c) {
            result = "CCC";
        }
        if (4 == c) {
            result = "CD";
        }
        if (5 == c) {
            result = "D";
        }
        if (6 == c) {
            result = "DC";
        }
        if (7 == c) {
            result = "DCC";
        }
        if (8 == c) {
            result = "DCCC";
        }
        if (9 == c) {
            result = "CM";
        }

        return result + twoNumberToRoman(num % 100);

    }

    public static String fourNumberToRoman(int num) {
        //m是千位数
        int m = num / 1000;
        String result = "";
        if (1 == m) {
            result = "M";
        }
        if (2 == m) {
            result = "MM";
        }
        if (3 == m) {
            result = "MMM";
        }
        return result + threeNumberToRoman(num % 1000);

    }

    public static String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
