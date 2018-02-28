package com.example.alg.matrixpck;

public class MaxAreaIsland {


    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

     Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

     Example 1:
     [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
     Example 2:
     [[0,0,0,0,0,0,0,0]]
     Given the above grid, return 0.
     */
    public int maxAreaOfIsland(int[][] grid) {

        if(grid==null){
            return 0;
        }

        int maxArea = 0;

        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    final int currentArea = areaIsland(grid, i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int areaIsland(int[][] grid, int i, int j) {
        boolean iInvalid = i<0 || i>=grid.length;
        boolean jInvalid = j<0 || j>=grid[0].length;
        if(iInvalid || jInvalid || grid[i][j]!=1 || grid[i][j]=='V'){
            return 0;
        }
        grid[i][j]='V';//visited part of island
        int area = 1;

        area += areaIsland(grid, i-1, j); // north island
        area += areaIsland(grid, i, j-1); // vest island
        area +=areaIsland(grid, i, j+1); //east island
        area += areaIsland(grid, i+1, j); //south island

        return area;
    }
}
