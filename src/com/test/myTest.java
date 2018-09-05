package com.test;

import com.medium.wordSearch.*;

public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][]board2 = {
                {'a'},
                {'a'}
        };
        String target = "aaa";
        System.out.println(solution.exist(board2,target));
    }


}
