package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianArrayTest {
    @Test
    public void findMedianSortedArrays() throws Exception {

        final MedianArray m = new MedianArray();
        assertEquals(2.0, m.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 0);
        assertEquals(2.5, m.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 0);

    }

}