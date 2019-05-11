package com.medium.wordLadder;


import javafx.util.Pair;

import java.util.*;


/**
 * @author chenlangping
 * @date 2019-05-11
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] word = {"hot", "dot", "dog", "lot", "log", "cog"};
        Collections.addAll(wordList, word);
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
            return 0;
        }

        if (!wordList.contains(endWord)) {
            return 0;
        }

        if (beginWord.length() != endWord.length()) {
            return 0;
        }


        int length = beginWord.length();

        //正式开始算法，首先需要对list进行一个预处理
        //创建一个字典，其中的每个key就是wordList中的词经过一个字母变换能够得到的值，而value就是对应的key所能够到达的
        //打个比方 "*og"=[dog, log, cog]
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>(0);

        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (allComboDict.containsKey(newWord)) {
                    allComboDict.get(newWord).add(word);
                } else {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.add(word);
                    allComboDict.put(newWord, tmp);
                }
            }
        }
        //预处理完毕

        //下面的pair就是一个键值对的类
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        //这个列表存放word是否访问过
        ArrayList<String> visited = new ArrayList<>();
        visited.add(beginWord);

        //BFS的核心算法
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    //下面是优化的部分，防止大规模循环或者形成环
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
