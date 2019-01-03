package com.medium.grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        } else if (n == 0) {
            res.add(0);
            return res;
        } else if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        } else {
            res.add(0);
            res.add(1);
            for (int i = 1; i < n; i++) {
                int tmp = (int) Math.pow(2, i);
                for (int j = tmp - 1; j >= 0; j--) {
                    res.add(res.get(j) + tmp);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(4));
    }
}
