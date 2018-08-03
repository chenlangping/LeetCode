package com.easy.longestcommonprefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        int index = 0;
        while(true){
            for(String str:strs){
                if(index==str.length() || str.charAt(index) != strs[0].charAt(index)){
                    return strs[0].substring(0,index);
                }
                //每一轮比较所有字符串的第index个字符
            }
            index++;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] strs = {"aflower","flow","flight"};//这里我觉得应该返回"fl"，实际上应该需要返回""
        System.out.print(solution.longestCommonPrefix(strs));
    }



}
