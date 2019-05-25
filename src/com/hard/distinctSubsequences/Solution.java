package com.hard.distinctSubsequences;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author chenlangping
 * @date 2019-05-25
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babgbag";
        String t = "bag";
        System.out.println(solution.numDistinct2(s, t));
    }

    public int numDistinct(String s, String t) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {

                if (t.charAt(i) == s.charAt(j)) {
                    tmp.add(j);
                }
            }
            if (tmp.size() == 0) {
                return 0;
            }
            map.put(i, tmp);
        }

        for (int i = 1; i < t.length(); i++) {
            map.put(0, helper(map.get(0), map.get(i)));
        }

        return map.get(0).size();


    }

    public ArrayList<Integer> helper(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : a1) {
            for (Integer j : a2) {
                if (i < j) {
                    res.add(j);
                }
            }
        }
        return res;
    }

    public int numDistinct2(String s, String t) {
        int[][] res = new int[t.length() + 1][s.length() + 1];

        //1. 初始化
        for (int j = 0; j <= s.length(); j++) {
            res[0][j] = 1;
        }

        //2. 动态规划
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    res[i + 1][j + 1] = res[i][j] + res[i + 1][j];
                } else {
                    res[i + 1][j + 1] = res[i + 1][j];
                }
            }
        }

        return res[t.length()][s.length()];
    }
}
