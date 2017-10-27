package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathTest {
    @Test
    public void uniquePathsWithObstacles() throws Exception {
        final UniquePath u = new UniquePath();
        int[][]matrix =
                {{0,0,0},
                 {0,1,0},
                 {0,0,0}};
        assertEquals(2, u.uniquePathsWithObstacles(matrix));
    }

    @Test
    public void uniquePaths() throws Exception {
        final UniquePath u = new UniquePath();
        assertEquals(6, u.uniquePaths(3,3));
    }

}