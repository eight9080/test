package com.example.alg.matrixpck;

public class MinPathSum {


    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

     Note: You can only move either down or right at any point in time.

     Example 1:
     [[1,3,1],
     [1,5,1],
     [4,2,1]]
     Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int noRows = grid.length;
        int noColumns = grid[0].length;

        int[] sums = new int[noColumns];
        sums[0] = grid[0][0];

        //firsRow
        for(int i = 1; i< noColumns; i++){
            sums[i]= sums[i-1]+grid[0][i];
        }

        for(int rowIndex =1; rowIndex< noRows; rowIndex++){
            //first column
            sums[0] = sums[0]+grid[rowIndex][0];

            for(int columnIndex = 1; columnIndex< noColumns; columnIndex++){
                //get min left(columnIndex-1) or top(rowIndex-1)
                sums[columnIndex] = Math.min(sums[columnIndex-1], sums[columnIndex]) + grid[rowIndex][columnIndex];
            }
        }

        return sums[noColumns-1];
    }

}
