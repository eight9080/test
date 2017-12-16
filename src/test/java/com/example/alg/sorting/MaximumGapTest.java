package com.example.alg.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumGapTest {
    @Test
    public void maximumGap() throws Exception {
        final MaximumGap m = new MaximumGap();
        final int maximumGap = m.maximumGap(new int[]{3, 5, 4, 2, 8});
        assertEquals(3, maximumGap);

    }

}