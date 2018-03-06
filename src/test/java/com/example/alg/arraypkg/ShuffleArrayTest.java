package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShuffleArrayTest {

    @Test
    public void shufleArray() {
        final int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        ShuffleArray.shufleArray(input);
        assertArrayEquals(new int[]{1,5,2,6,3,7,4,8}, input);
    }
}