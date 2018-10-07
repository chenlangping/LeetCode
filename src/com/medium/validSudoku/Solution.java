package com.medium.validSudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //按列检查
        for (int i = 0; i < 9; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (list.contains(board[i][j])) {
                    return false;
                } else if (isNumber(board[i][j])) {
                    list.add(board[i][j]);
                }
            }
        }

        //按行检查
        for (int j = 0; j < 9; j++) {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (list.contains(board[i][j])) {
                    return false;
                } else if (isNumber(board[i][j])) {
                    list.add(board[i][j]);
                }
            }
        }

        for (int k = 0; k < 3; k++) {
            List<Character> list = new ArrayList<>();
            for (int i = 3 * k; i < 3 * k + 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (list.contains(board[i][j])) {
                        return false;
                    } else if (isNumber(board[i][j])) {
                        list.add(board[i][j]);
                    }
                }
            }
            list.clear();
            for (int i = 3 * k; i < 3 * k + 3; i++) {
                for (int j = 3; j < 6; j++) {
                    if (list.contains(board[i][j])) {
                        return false;
                    } else if (isNumber(board[i][j])) {
                        list.add(board[i][j]);
                    }
                }
            }
            list.clear();
            for (int i = 3 * k; i < 3 * k + 3; i++) {
                for (int j = 6; j < 9; j++) {
                    if (list.contains(board[i][j])) {
                        return false;
                    } else if (isNumber(board[i][j])) {
                        list.add(board[i][j]);
                    }
                }
            }
        }


        return true;
    }

    public static boolean isNumber(char a) {
        if (a - '0' >= 0 && a - '0' <= 9) {
            return true;
        }
        return false;
    }

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }
}
