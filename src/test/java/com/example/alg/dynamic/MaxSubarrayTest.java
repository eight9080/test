package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubarrayTest {

    @Test
    public void maxSubArray() throws Exception {

        final MaxSubarray m = new MaxSubarray();
        final int maxSubArray = m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, maxSubArray);

    }

}