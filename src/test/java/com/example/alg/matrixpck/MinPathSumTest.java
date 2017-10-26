package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinPathSumTest {
    @Test
    public void minPathSum() throws Exception {

        final MinPathSum m = new MinPathSum();
        int[][]matrix = {{1,3,1},
                         {1,5,1},
                         {4,2,1}};
        assertEquals(7, m.minPathSum(matrix));

    }

}