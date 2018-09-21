package com.medium.triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len <= 0) {
            return 0;
        }
        if (1 == len) {
            return triangle.get(0).get(0);
        }
        //num用来记录中间的答案
        int[] num = new int[len - 1];
        //i控制在第几行，j控制在第几列，从最后第二行开始
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                //left记录左下方的数字(emmm其实应该是正下方)
                int left = triangle.get(i + 1).get(j);
                //right记录右下方的数字
                int right = triangle.get(i + 1).get(j + 1);
                //self是自己
                int self = triangle.get(i).get(j);
                //num用来记录结果
                num[j] = Math.min(left + self, right + self);
                //把新的结果设置上
                triangle.get(i).set(j, num[j]);
            }
        }
        return num[0];
    }
}
