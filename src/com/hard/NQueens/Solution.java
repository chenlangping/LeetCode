package com.hard.NQueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();

        if (n < 1) {
            return result;
        }
        recursive(board, 0, result);
        return result;
    }

    //递归函数
    private void recursive(char[][] board, int col, List<List<String>> result) {
        //如果已经遍历完了
        if (col == board.length) {
            result.add(transmit(board));
            return;
        }

        //从一行的最左边到最右边
        for (int i = 0; i < board.length; i++) {
            if (check(board, i, col)) {
                board[i][col] = 'Q';
                recursive(board, col + 1, result);
                board[i][col] = '.';
            }
        }
    }

    //确认能否放到xy处
    private boolean check(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

    //转换结果
    private List<String> transmit(char[][] board) {
        List<String> result = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(5));
    }
}
