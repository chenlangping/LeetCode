package com.medium.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean flag = true;
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        for (String s : strs) {
            flag = true;
            for (int i = 0; i < res.size(); i++) {
                List<String> tmp = res.get(i);
                if (isAnagram(tmp.get(0), s)) {
                    tmp.add(s);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                res.add(tmp);
            }
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            //长度都不相同还怎么可能是
            return false;
        }
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] != 0) {
                return false;
            }
        }

        return true;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        //最多10609个z
        // prime.length = 26

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
        System.out.println(solution.groupAnagrams2(strs));
    }


}
