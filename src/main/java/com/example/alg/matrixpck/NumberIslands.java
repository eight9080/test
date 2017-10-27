package com.example.alg.matrixpck;

public class NumberIslands {
    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.

     Example 1:

     11110
     11010
     11000
     00000
     Answer: 1

     Example 2:

     11000
     11000
     00100
     00011
     Answer: 3
     */
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0||grid[0].length==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int noIslands=0;
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    noIslands++;
                    visitIsland(grid, i, j);
                }
            }
        }
        return noIslands;
    }

    private void visitIsland(char[][] grid, int i, int j) {
        boolean iInvalid = i<0 || i>=grid.length;
        boolean jInvalid = j<0 || j>=grid[0].length;
        if(iInvalid || jInvalid || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='V';//visited part of island

        visitIsland(grid, i-1, j); //north island
        visitIsland(grid, i, j+1); //east island
        visitIsland(grid, i+1, j); //south island
        visitIsland(grid, i, j-1); //west island

    }
}
