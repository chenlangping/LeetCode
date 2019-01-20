package com.hard.validNumber;

public class Solution {
    public boolean isNumber(String s) {
        boolean hasE = false;
        int numOfPlus = 0;
        int numOfMinus = 0;
        boolean hasPoint = false;
        if (s.length() == 0) {
            return false;
        }
        s = s.trim();
        for (char c : s.toCharArray()) {
            //合法的只可能有 +-.e 0-9这几种，且+-.e只可能出现一次
            if (c == '+') {
                if (numOfPlus == 2) {
                    return false;
                }
                numOfPlus++;
            } else if (c == '-') {
                if (numOfMinus == 2) {
                    return false;
                }
                numOfMinus++;
            } else if (c == '.') {
                if (hasPoint) {
                    return false;
                }
                hasPoint = true;
            } else if (c == 'e') {
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (Character.isDigit(c)) {
                continue;
            } else {
                return false;
            }
        }

        if (hasE) {
            //如果有e 则以e为中间点分割
            String[] res = s.split("e");
            if (res.length != 2) {
                return false;
            }
            String front = res[0];
            String back = res[1];

            if (isUnsignedDecimal(front) || isUnsignedInteger(front) || isSignedDecimal(front) || isSignedInteger(front)) {
                if (isSignedInteger(back) || isUnsignedInteger(back)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            //没有e
            if (isUnsignedDecimal(s) || isUnsignedInteger(s) || isSignedDecimal(s) || isSignedInteger(s)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isUnsignedInteger(String s) {
        //判断是不是无符号的整数
        if (s.length() == 0 || s == null) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isUnsignedDecimal(String s) {
        //判断是不是无符号的小数
        if (s.length() == 1 && s.charAt(0) == '.') {
            return false;
        }
        if (s.length() == 0 || s == null) {
            return false;
        }
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (flag >= 0) {
                    return false;
                } else {
                    flag = i;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSignedInteger(String s) {
        if (s.length() == 0 || s == null) {
            return false;
        }
        if ((s.charAt(0) == '-' || s.charAt(0) == '+') && isUnsignedInteger(s.substring(1))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSignedDecimal(String s) {
        if (s.length() == 0 || s == null) {
            return false;
        }
        if ((s.charAt(0) == '-' || s.charAt(0) == '+') && isUnsignedDecimal(s.substring(1))) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "+42e+76125";
        System.out.println(solution.isNumber(s));
        System.out.println(solution.isSignedInteger("+76123"));
    }
}
