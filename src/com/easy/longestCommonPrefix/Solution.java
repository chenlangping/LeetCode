package com.easy.longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        while (true) {
            for (String str : strs) {
                if (index == str.length() || str.charAt(index) != strs[0].charAt(index)) {
                    return strs[0].substring(0, index);
                }
                //每一轮比较所有字符串的第index个字符
            }
            index++;
        }
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++){
            if(result.isEmpty()){
                return "";
            }
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) return "";
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"aflower", "flow", "flight"};//这里我觉得应该返回"fl"，实际上应该需要返回""
        System.out.print(solution.longestCommonPrefix2(strs));
    }


}
