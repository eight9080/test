package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayTest {
    @Test
    public void removeDuplicates() throws Exception {
        final SortedArray s = new SortedArray();
        final int[] input = {1, 1, 2};
        assertEquals(2,s.removeDuplicates(input));
        assertArrayEquals(new int[]{1,2,2}, input);
    }

}