package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayCroppedTest {

    @Test
    public void test() {
        int[][][] example = {
                {{0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {1, 1, 1, 0},
                        {0, 0, 0, 0}},

                {{0, 1, 0},
                        {0, 0, 1},
                        {1, 1, 1}}
        };
        int[][] res = ArrayCropped.getCroppedFieldAsArray(example[0]);
        assertArrayEquals(example[1], res);
    }
}