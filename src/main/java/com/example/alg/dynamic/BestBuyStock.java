package com.example.alg.dynamic;

public class BestBuyStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Example 1:
     * Input: [7, 1, 5, 3, 6, 4]
     * Output: 5
     * <p>
     * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     * Example 2:
     * Input: [7, 6, 4, 3, 1]
     * Output: 0
     * <p>
     * In this case, no transaction is done, i.e. max profit = 0.
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            final int priceOfDay = prices[i];
            if (min > priceOfDay) {
                min = priceOfDay;
                continue;
            }
            if(priceOfDay-min>profit){
                profit = priceOfDay-min;
            }

        }

        return profit;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete as many transactions as you
     like (ie, buy one and sell one share of the stock multiple times).
     However, you may not engage
     in multiple transactions at the same time
     (ie, you must sell the stock before you buy again).
     */
    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;

        int profit = 0;
        for (int i = 0; i <= prices.length - 2; i++) {
            final int profitBetweenDays = prices[i + 1] - prices[i];
            if(profitBetweenDays>0){
                profit+=profitBetweenDays;
//                i++;
            }
        }

        return profit;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete at most two transactions.

     Note:
     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        //highest profit in 0 ... i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right
        left[0] = 0;
        int minBuyInPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minBuyInPrice = Math.min(minBuyInPrice, prices[i]);
            left[i] = Math.max(prices[i]-minBuyInPrice, left[i-1]);
        }

        // DP from right to left
        right[prices.length - 1] = 0;
        int maxSellOutPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxSellOutPrice = Math.max(maxSellOutPrice, prices[i]);
            right[i] = Math.max(maxSellOutPrice-prices[i], right[i+1]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i]+right[i]);
        }

        return profit;

    }


    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     https://www.youtube.com/watch?v=oDhu5uGq_ic
     Design an algorithm to find the maximum profit. You may complete at most k transactions.
     */
    public int maxProfit4(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  prices.length/2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int T[][] = new int[k+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[k][prices.length-1];
    }

}
