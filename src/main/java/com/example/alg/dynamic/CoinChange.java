package com.example.alg.dynamic;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

     Example 1:
     coins = [1, 2, 5], amount = 11
     return 3 (11 = 5 + 5 + 1)

     Example 2:
     coins = [2], amount = 3
     return -1.

     Note:
     You may assume that you have an infinite number of each kind of coin.
     */
    public int coinChange(int[] coins, int amount) {

        if(amount==0) return 0;

        int[] dp = new int [amount+1];
        dp[0]=0; // 0 amount no coins

        for(int i=1;i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<=amount; i++){

            for(int coin: coins){
                long partAmount = (i+ (long)coin);
                if(partAmount <=amount){
                    if(dp[i]==Integer.MAX_VALUE){
                        dp[i+coin] = dp[i+coin];
                    }else{
                        dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                    }
                }
            }

        }

        if(dp[amount] >= Integer.MAX_VALUE)
            return -1;

        return dp[amount];

    }

    /**
     * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

     Note: You can assume that

     0 <= amount <= 5000
     1 <= coin <= 5000
     the number of coins is less than 500
     the answer is guaranteed to fit into signed 32-bit integer
     Example 1:

     Input: amount = 5, coins = [1, 2, 5]
     Output: 4
     Explanation: there are four ways to make up the amount:
     5=5
     5=2+2+1
     5=2+1+1+1
     5=1+1+1+1+1
     Example 2:

     Input: amount = 3, coins = [2]
     Output: 0
     Explanation: the amount of 3 cannot be made up just with coins of 2.
     Example 3:

     Input: amount = 10, coins = [10]
     Output: 1

     */
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <=amount ; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        return change2(amount, coins, 0, new HashMap<>());
    }

    public int change2(int amount, int[] coins, int index,  Map<String, Integer> memo) {
        if(amount==0){
            return 1;
        }
        if(index>=coins.length){
            return 0;
        }

        String key = amount+"-"+index;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int amountWithCoin = 0;
        int ways = 0;
        while (amountWithCoin<=amount){
            int remaining = amount - amountWithCoin;
            ways += change2(remaining, coins, index+1, memo);
            amountWithCoin+=coins[index];
        }
        memo.put(key, ways);
        return ways;
    }

}
