package com.medium.letterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (0 == digits.length()) {
            return result;
        }
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recursion("", 0, digits, result, map);
        return result;
    }

    private void recursion(String curString, int curIndex, String digits, List<String> result, String[] map) {
        //curString是目前的组合，还没有到底，curIndex是目前digits中的下标
        if (curIndex == digits.length() - 1) {
            for (int i = 0; i < map[digits.charAt(curIndex) - '0'].length(); i++) {
                String finalString = curString + map[digits.charAt(curIndex) - '0'].charAt(i);
                result.add(finalString);
            }
            return;
        }
        for (int i = 0; i < map[digits.charAt(curIndex) - '0'].length(); i++) {
            recursion(curString + map[digits.charAt(curIndex) - '0'].charAt(i), curIndex + 1, digits, result, map);
        }
    }

}
