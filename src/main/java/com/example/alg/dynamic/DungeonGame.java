package com.example.alg.dynamic;

public class DungeonGame {
    /**
     * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

     The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

     Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

     In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


     Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

     For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

     -2 (K)	-3	3
     -5	-10	1
     10	30	-5 (P)

     */
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;

        //init dp table
        int[][] dp = new int[rows][columns];

        dp[rows-1][columns-1] = Math.max(1 - dungeon[rows-1][columns-1],1);

        //last row
        for(int j = columns-2; j>=0; j--){
            dp[rows-1][j]=Math.max(dp[rows-1][j+1]-dungeon[rows-1][j], 1);
        }

        //last column
        for (int i = rows-2; i >=0 ; i--) {
            dp[i][columns-1]= Math.max(dp[i+1][columns-1]-dungeon[i][columns-1],1);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {

                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);

            }
        }

        return dp[0][0];
    }

}
