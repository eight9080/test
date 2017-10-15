package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangularHistogramTest {
    @Test
    public void largestRectangleArea() throws Exception {
        final LargestRectangularHistogram l = new LargestRectangularHistogram();
        assertEquals(10, l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}