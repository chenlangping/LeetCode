package com.hard.substringWithConcatenationOfAllWords;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        //有多少单词
        int numOfWord = words.length;

        if (numOfWord == 0) {
            return res;
        }

        //每个单词的长度
        int wordLen = words[0].length();

        //把所有单词放进map1里面
        Map<String, Integer> map1 = stringToMap(words, numOfWord);

        for (int i = 0; i < s.length() - wordLen * numOfWord + 1; i++) {
            Map<String, Integer> map2 = getMap(i, wordLen, numOfWord, s);
            if (compareMap(map1, map2)) {
                res.add(i);
            }
        }

        return res;
    }

    //用所给的字符串，指定开始，并且指定每个单词的长度，来构造map
    public Map<String, Integer> getMap(int start, int wordLen, int numOfWord, String s) {
        String words[] = new String[numOfWord];
        int j = 0;
        for (int i = start; i < start +numOfWord * wordLen; i = i + wordLen) {
            words[j] = s.substring(i, i + wordLen);
            j++;
        }
        Map<String, Integer> map = stringToMap(words, numOfWord);
        return map;
    }

    private Map<String, Integer> stringToMap(String words[], int numOfWord) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < numOfWord; i++) {
            if (map.containsKey(words[i])) {
                int count = map.get(words[i]);
                count++;
                map.put(words[i], count);
            } else {
                map.put(words[i], 1);
            }
        }
        return map;
    }

    private boolean compareMap(Map<String, Integer> m1, Map<String, Integer> m2) {

        Iterator<Map.Entry<String, Integer>> iter1 = m1.entrySet().iterator();
        while (iter1.hasNext()) {
            Map.Entry<String, Integer> entry1 = iter1.next();
            int m1value = entry1.getValue() == null ? -1 : entry1.getValue();
            int m2value = m2.get(entry1.getKey()) == null ? -2 : m2.get(entry1.getKey());

            if (m1value != m2value) {
                return false;
            }
        }
        return true;
    }

    public void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String words[] = {"foo", "bar"};
        System.out.println(solution.findSubstring(s, words));
    }
}
