package com.example.alg.matrixpck;

public class UniquePath {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     The robot can only move either down or right at any point in time.
     The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     How many possible unique paths are there?
     Above is a 3 x 7 grid. How many possible unique paths are there?
     Note: m and n will be at most 100.
     */
    public int uniquePaths(int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        int[] paths = new int[n];

        //first row
        for(int col = 0; col<n; col++) {
            paths[col] = 1;
        }


        for(int row = 1; row<m; row++){
            for(int col = 1; col<n; col++){
                paths[col] = paths[col-1]+paths[col];
            }
        }
        return paths[n-1];

    }

    /**
     * Follow up for "Unique Paths":
     Now consider if some obstacles are added to the grids. How many unique paths would there be?
     An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     For example,
     There is one obstacle in the middle of a 3x3 grid as illustrated below.
     [
     [0,0,0],
     [0,1,0],
     [0,0,0]
     ]
     The total number of unique paths is 2.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int noRows = obstacleGrid.length;
        int noColumns = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[noRows - 1][noColumns - 1] == 1) {
            return 0;
        }

        int[] paths = new int[noColumns];

        paths[0] = 1;

        for(int row = 0; row<noRows; row++){
            if(obstacleGrid[row][0]==1){
                paths[0]=0;
            }
            for(int col = 1; col<noColumns; col++){
                if(obstacleGrid[row][col]==1){
                    paths[col]=0;
                }else {
                    paths[col]=paths[col-1]+paths[col];
                }
            }
        }
        return paths[noColumns-1];
    }


}
