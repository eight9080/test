package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareSortedArrayTest {

    @Test
    public void sortedSquares() {
        final SquareSortedArray s = new SquareSortedArray();
        assertArrayEquals(new int[]{0,1,9,16,100}, s.sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        assertArrayEquals(new int[]{4,9,9,49,121}, s.sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}