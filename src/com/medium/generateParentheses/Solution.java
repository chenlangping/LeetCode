package com.medium.generateParentheses;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        createParentheses(list, "", 0, n);
        return list;
    }

    //j是左括号有多少个，i是右括号有多少个
    //思路是当j>0时就不断深入，j=0，这意味着左括号用完了，如果i=0 说明也匹配完了，然后就可以写入
    private void createParentheses(List<String> list, String str, int i, int j) {
        if (i == 0 && j == 0) {
            list.add(str);
            return;
        }
        if (j > 0) createParentheses(list, str + "(", i + 1, j - 1);
        if (i > 0) createParentheses(list, str + ")", i - 1, j);
    }
}