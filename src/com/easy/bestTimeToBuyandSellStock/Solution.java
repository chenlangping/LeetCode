package com.easy.bestTimeToBuyandSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        //maxCur用来记录当前序列中(不一定是从0开始的)最大的，maxSoFar用来记录从头到目前为止最大的
        int maxCur = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            //为什么当maxCur<0的时候要把它置成0呢？相当于是找到一个比目前最小的还要小的了，需要从头开始的意思
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
