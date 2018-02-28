package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAreaIslandTest {

    @Test
    public void maxAreaOfIsland() {
        final MaxAreaIsland m = new MaxAreaIsland();

        int[][] gridSmall1 =  {
                {0,1,0,1,0,0},
                {0,1,1,1,0,0},
                {0,0,0,1,0,0},
                {1,1,1,0,0,0},
                {1,1,0,0,0,0}
        };

        assertEquals(6, m.maxAreaOfIsland(gridSmall1));

        int[][] gridSmall =  {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0},
        };
        assertEquals(7, m.maxAreaOfIsland(gridSmall));



        int[][] grid =  {
                 {0,0,1,0,0,0,0,1,0,0,0,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        assertEquals(6, m.maxAreaOfIsland(grid));

        assertEquals(0, m.maxAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));

    }
}