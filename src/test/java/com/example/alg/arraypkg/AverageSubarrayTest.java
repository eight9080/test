package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class AverageSubarrayTest {

    @Test
    public void findMaxAverage() {

        final AverageSubarray a = new AverageSubarray();

        assertEquals(-1,
                a.findMaxAverage(new int[]{-1}, 1), 0);

        assertEquals(5,
                a.findMaxAverage(new int[]{5}, 1), 0);

        assertEquals(4,
                a.findMaxAverage(new int[]{0,4,0,3,2}, 1), 0);
        assertEquals(12.75,
                a.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4), 0);

    }
}