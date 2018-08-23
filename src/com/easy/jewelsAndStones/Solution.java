package com.easy.jewelsAndStones;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public int numJewelsInStones2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public int numJewelsInStones3(String J, String S) {
        Set set = new HashSet();
        int sum = 0;
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        //String J = "z", S = "ZZ";
        Solution s = new Solution();
        System.out.println(s.numJewelsInStones3(J, S));
    }
}
