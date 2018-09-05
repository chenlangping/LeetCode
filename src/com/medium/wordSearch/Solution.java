package com.medium.wordSearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] newWord = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != newWord[0]) {
                    continue;
                }
                if (recursion(board, newWord, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recursion(char[][] board, char[] newWord, int x, int y, int index) {
        //这里这个判断条件反而是最难想到的，想象word=1的时候，它的四个方向都是错误的，但是因为这个判断可以使答案正确
        if (index == newWord.length) {
            return true;
        }
        //越界判断
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length) {
            return false;
        }
        //如果目前的位置和要求不一致
        if (board[x][y] != newWord[index]) {
            return false;
        }

        //这一步使borad[x][y]变成非字符
        char temp = board[x][y];
        board[x][y] = '我';
        //判断四个方向是否存在
        boolean result = recursion(board, newWord, x - 1, y, index + 1) ||
                recursion(board, newWord, x + 1, y, index + 1) ||
                recursion(board, newWord, x, y - 1, index + 1) ||
                recursion(board, newWord, x, y + 1, index + 1);
        //这一步使borad[x][y]变回来
        board[x][y] = temp;
        return result;
    }
}
