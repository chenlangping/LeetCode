package com.hard.bestTimeToBuyAndSellStockIII;

public class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i : prices) {
            //如果我们进行了第二次出售可以获得的总钱数
            sell2 = Math.max(sell2, buy2 + i);
            //如果我们进行了第二次购入可以获得的总钱数
            buy2 = Math.max(buy2, sell1 - i);

            //---------------分割线---------------------

            //如果我们进行了第一次出售可以获得的总钱数
            sell1 = Math.max(sell1, buy1 + i);
            //如果我们进行了第一次购入可以获得的总钱数
            buy1 = Math.max(buy1, -i);
        }
        return sell2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int prices[] = {113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        System.out.println(solution.maxProfit(prices));
    }
}
