package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextPermutationTest {

    @Test
    public void nextPermutation() {

        final NextPermutation n = new NextPermutation();

        final int[] input5 = {1,3,2};
        n.nextPermutation(input5);
        assertArrayEquals(new int[]{2,1,3}, input5);

        final int[] input1 = {1, 2, 3};
        n.nextPermutation(input1);
        assertArrayEquals(new int[]{1,3,2}, input1);

        final int[] input2 = {3,2,1};
        n.nextPermutation(input2);
        assertArrayEquals(new int[]{1,2,3}, input2);

        final int[] input3 = {1,1,5};
        n.nextPermutation(input3);
        assertArrayEquals(new int[]{1,5,1}, input3);

    }
}