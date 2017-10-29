package com.example.alg.matrixpck;

import java.util.List;

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

    /**
     * A 2d grid map of m rows and n columns is initially filled with water.
     * We may perform an addLand operation which turns the water at position (row, col) into a land.
     * Given a list of positions to operate, count the number of islands after each addLand operation.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]. Initially,
     * the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
     0 0 0
     0 0 0
     0 0 0
     Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
     1 0 0
     0 0 0   Number of islands = 1
     0 0 0
     Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
     1 1 0
     0 0 0   Number of islands = 1
     0 0 0
     Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
     1 1 0
     0 0 1   Number of islands = 2
     0 0 0
     Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
     1 1 0
     0 0 1   Number of islands = 3
     0 1 0
     We return the result as an array: [1, 1, 2, 3].
     Use Union-Find Set to solve this problem. to use this alogrithm,
     we need to design a set of APIs we can follow while updating the required data structure,
     this API + data structure will:
     assign a id for each element(the data structure),
     in this case, each island/water area initially has -1 as its id.
     API-1 find(map, i...), return the id for certain element in the map.
     If 2 id returned is not the same, then use API-2 union() try to merge elements with these two ids.
     Quick-Find solution, O(kmn)
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        //TODO do problem
    return null;
    }
}
