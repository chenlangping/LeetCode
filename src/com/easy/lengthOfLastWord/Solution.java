package com.easy.lengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        //特殊情况处理
        if (s.length() == 0) {
            return 0;
        }
        int result = 0;
        int i = s.length() - 1;
        int j = 0;

        //对最后的空格进行记录
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
            j++;
        }

        //计算最后一个单词的长度
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                result = s.length() - i - 1 - j;
                break;
            }
            if (0 == i) {
                result = s.length() - j;
                break;
            }
            i--;
        }
        return result;
    }

    public int lengthOfLastWord2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
