package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayTest {
    @Test
    public void removeDuplicates2() throws Exception {

        final SortedArray s = new SortedArray();

        int[] input = {1,1,1,1,3,3};
        assertEquals(4,s.removeDuplicates2(input));
        assertArrayEquals(new int[]{1,1,3,3,3,3}, input);

        input = new int[]{1, 1, 1, 2, 2, 3};
        assertEquals(5,s.removeDuplicates2(input));
        assertArrayEquals(new int[]{1,1,2,2,3,3}, input);

    }

    @Test
    public void removeDuplicates() throws Exception {
        final SortedArray s = new SortedArray();
        final int[] input = {1, 1, 2};
        assertEquals(2,s.removeDuplicates(input));
        assertArrayEquals(new int[]{1,2,2}, input);
    }

    @Test
    public void transitionPoint(){
        final SortedArray s = new SortedArray();
        assertEquals(3, s.transitionPoint(new int[]{0, 0, 0, 1, 1}, 5));
    }

    @Test
    public void findExtra() {
        final SortedArray s = new SortedArray();
        assertEquals(6, s.findExtra(new int[]{1, 3, 5, 7, 9, 11}, new int[]{1, 3, 5, 7, 9, 11, 21}, 6));
        assertEquals(4, s.findExtra(new int[]{2, 4, 6, 8, 9, 10, 12}, new int[]{2, 4, 6, 8, 10, 12}, 7));
        assertEquals(3, s.findExtra(new int[]{3, 5, 7, 9, 11, 13}, new int[]{3, 5, 7, 11, 13}, 6));

    }
}