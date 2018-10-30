package com.hard.NQueensII;

public class Solution {
    public int totalNQueens(int n) {
        int res[] = new int[1];
        res[0] = 0;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        recursive(board, 0, res);
        return res[0];
    }

    private void recursive(char[][] board, int row, int[] res) {
        if (row == board.length) {
            res[0]++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (check(board, row, j)) {
                board[row][j] = 'Q';
                recursive(board, row + 1, res);
                board[row][j] = '.';
            }
        }

    }

    private boolean check(char[][] board, int x, int y) {
        //同一行是不可能有两个Q的，因为在执行的时候就已经排除了
        //首先看同一列有没有Q
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }

        //接下来看左上方对角线
        int left = x - 1;
        int up = y - 1;
        while (left >= 0 && up >= 0) {
            if (board[left][up] == 'Q') {
                return false;
            }
            left--;
            up--;
        }

        //接下来看右上方对角线
        int right = x - 1;
        up = y + 1;
        while (right >= 0 && up < board.length) {
            if (board[right][up] == 'Q') {
                return false;
            }
            right--;
            up++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(8));
    }

}
