package com.hard.expressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return result;
        }
        recurse(result, "", num, target, 0, 0, 0);
        return result;
    }

    public void recurse(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                recurse(result, path + cur, num, target, i + 1, cur, cur);
            } else {
                recurse(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                recurse(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                recurse(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public int expressionToInteger(String s) {
        int firstNumberEnd = 0;
        int number1 = 0;
        int number2 = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                number1 = number1 * 10 + s.charAt(i) - '0';
            } else {
                firstNumberEnd = i;
                if (s.charAt(i) == '+') {
                    operator = '+';
                }
                if (s.charAt(i) == '-') {
                    operator = '-';
                }
                if (s.charAt(i) == '*') {
                    operator = '*';
                }
                break;
            }
        }

        for (int i = firstNumberEnd + 1; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                number2 = number2 * 10 + s.charAt(i) - '0';
            } else {
                if (operator == '+') {
                    number1 = number1 + number2;
                    number2 = 0;
                } else if (operator == '-') {
                    number1 = number1 - number2;
                    number2 = 0;
                } else if (operator == '*') {
                    number1 = number1 * number2;
                    number2 = 0;
                }
            }
            if (s.charAt(i) == '+') {
                operator = '+';
            } else if (s.charAt(i) == '-') {
                operator = '-';
            } else if (s.charAt(i) == '*') {
                operator = '*';
            }
        }
        return number1;
    }

    public List<String> getAllNumbers(String s) {
        List<String> result = new ArrayList<>();
        List<String> left, right;
        result.add(s);
        result.add(s);
        for (int i = 1; i < s.length(); i++) {
            left = getAllNumbers(s.substring(0, i));
            right = getAllNumbers(s.substring(i));
            for (int j = 0; j < left.size(); j = j + 2) {
                for (int k = 0; k < right.size(); k = k + 2) {
                    int leftNum = Integer.parseInt(left.get(j + 1));
                    int rightNum = Integer.parseInt(right.get(k + 1));
                    result.add(left.get(j) + "+" + right.get(k));
                    result.add(String.valueOf(leftNum + rightNum));

                    result.add(left.get(j) + "-" + right.get(k));
                    result.add(String.valueOf(leftNum - rightNum));

                    result.add(left.get(j) + "*" + right.get(k));
                    result.add(String.valueOf(leftNum * rightNum));
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "232";
        int target = 8;
        System.out.println(solution.addOperators(s,target));
    }
}
