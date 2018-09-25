package com.medium.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> result = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (result.containsKey(s.charAt(i))) {
                j = Math.max(j, result.get(s.charAt(i)) + 1);
            }
            result.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
