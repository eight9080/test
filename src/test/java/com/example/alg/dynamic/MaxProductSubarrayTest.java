package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductSubarrayTest {
    final MaxProductSubarray m = new MaxProductSubarray();
    @Test
    public void maxProduct() throws Exception {

        assertEquals(12, m.maxProduct(new int[]{-4, -3,-2}));
        assertEquals(6, m.maxProduct(new int[]{2,3,-2,4}));


    }

}