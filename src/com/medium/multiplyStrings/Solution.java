package com.medium.multiplyStrings;

public class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        if (m == 0 || n == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //两个对应位置的相乘
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //和还要加上之前进位的(如果有的话)
                int sum = mul + res[i + j + 1];
                //填入
                res[i + j] += sum / 10;
                res[i + j + 1] = (sum) % 10;
            }
        }

        for (int i : res) {
            if (stringBuilder.length() == 0 && i == 0) {
                //去除开头的0
                continue;
            }
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2));
    }
}
