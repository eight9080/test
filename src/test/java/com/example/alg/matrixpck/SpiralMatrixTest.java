package com.example.alg.matrixpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SpiralMatrixTest {
    @Test
    public void generateMatrix() throws Exception {
        final SpiralMatrix s = new SpiralMatrix();
        int[][]matrix = {{1,2,3},{8,9,4},{7,6,5}};
        assertArrayEquals(matrix, s.generateMatrix(3));
    }

    @Test
    public void spiralOrder() throws Exception {
        final SpiralMatrix s = new SpiralMatrix();
        int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        assertEquals(Arrays.asList(1,2,3,6,9,8,7,4,5), s.spiralOrder(matrix));
    }

}