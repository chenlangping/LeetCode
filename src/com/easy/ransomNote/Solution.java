package com.easy.ransomNote;

/**
 * @author chenlangping
 * @date 2019-06-01
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("aa", "ab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array1 = helper(ransomNote);
        int[] array2 = helper(magazine);
        for (int i = 0; i < 26; i++) {
            if (array2[i] < array1[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] helper(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a'] += 1;
        }
        return res;
    }
}
