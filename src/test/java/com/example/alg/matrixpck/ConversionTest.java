package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionTest {


    @Test
    public void setZeroes() throws Exception {

        int[][]matrix = {{1,1,1,0},{1,1,1,0},{1,1,0,0},{1,0,0,0}};

        final Conversion c = new Conversion();
        int[][]expected = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        c.setZeroes(matrix);
        assertArrayEquals(expected, matrix);

    }

}