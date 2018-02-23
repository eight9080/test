package com.example.alg.dynamic;

public class ClimbStair {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
     */

    public int climbStairs(int n) {

        if(n == 0 || n == 1 || n == 2){
            return n;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;

        for (int i = 2; i < n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }


    /**
     * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

     Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

     Example 1:
     Input: cost = [10, 15, 20]
     Output: 15
     Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     Example 2:
     Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     Output: 6
     Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     */
    public int minCostClimbingStairs(int[] cost) {


        if(cost==null || cost.length==0){
            return 0;
        }

        if(cost.length==1){
            return cost[0];
        }
        if(cost.length==2){
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-1])+cost[i];
        }

        return Math.min(dp[cost.length-2], dp[cost.length-1]);

    }
}
