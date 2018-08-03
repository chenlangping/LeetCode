package com.easy.jewelsandstones;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (int i = 0 ;i<J.length();i++){
            for(int j = 0;j<S.length();j++){
                if(J.charAt(i) == S.charAt(j)){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //String J = "aA", S = "aAAbbbb";
        String J = "z", S = "ZZ";
        Solution s = new Solution();
        System.out.println(s.numJewelsInStones(J,S));
    }
}
