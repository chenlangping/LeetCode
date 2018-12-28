package com.hard.wildcardMatching;

import com.structure.Matrix.Matrix;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                match[s.length()][i] = true;
        }

        Matrix.print(match);
        System.out.println();

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                else
                    match[i][j] = false;
            }
        }

        Matrix.print(match);

        return match[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "adcebeeeeee";
        String p = "*a*";
        System.out.println(solution.isMatch(s, p));
    }
}
