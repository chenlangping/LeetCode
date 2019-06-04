package com.easy.addStrings;

/**
 * @author chenlangping
 * @date 2019-06-01
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("1", "9"));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 0;
        while (i >= 0 && j >= 0) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int tmp = a + b;
            if ((tmp + flag) > 9) {
                stringBuilder.append(tmp + flag - 10);
                flag = 1;
            } else {
                stringBuilder.append(tmp + flag);
                flag = 0;
            }
            i--;
            j--;
        }

        if (i == -1 && j >= 0) {
            for (; j >= 0; j--) {
                if ((num2.charAt(j) - '0' + flag) > 9) {
                    stringBuilder.append(num2.charAt(j) - '0' + flag - 10);
                    flag = 1;
                } else {
                    stringBuilder.append(num2.charAt(j) - '0' + flag);
                    flag = 0;
                }
            }
        } else if (i >= 0 && j == -1) {
            for (; i >= 0; i--) {
                if ((num1.charAt(i) - '0' + flag) > 9) {
                    stringBuilder.append(num1.charAt(i) - '0' + flag - 10);
                    flag = 1;

                } else {
                    stringBuilder.append(num1.charAt(i) - '0' + flag);
                    flag = 0;

                }
            }
        }
        if (flag == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

}
