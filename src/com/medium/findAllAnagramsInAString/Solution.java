package com.medium.findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ababababab", p = "aab";
        for (int i : solution.findAnagrams2(s, p)) {
            System.out.println(i);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String tmp = s.substring(i, i + p.length());
            if (isAnagram(tmp, p)) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
        int[] table = new int[256];
        for (char c : p.toCharArray()) {
            table[c]++;
        }
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            if (table[s.charAt(right)] > 0) {
                count++;
            }
            table[s.charAt(right)]--;
            right++;

            if (count == p.length()) {
                res.add(left);
            }

            if (right - left == p.length()) {
                if (table[s.charAt(left)] >= 0) {
                    count--;
                }
                table[s.charAt(left)]++;
                left++;
            }

        }
        return res;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return res;
        }
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < p.length(); i++) {
            q1.offer((int) p.charAt(i));
        }
        for (int i = 0; i < p.length(); i++) {
            q2.offer((int) s.charAt(i));
        }

        int right = p.length();
        while (true) {
            if (q1.containsAll(q2) && q2.containsAll(q1) && q1.size() == q2.size()) {
                res.add(right - p.length());
            }
            if (right == s.length()) {
                break;
            }
            q2.offer((int) s.charAt(right));
            q2.poll();
            right++;
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
}
