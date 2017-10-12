package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAreaTest {
    @Test
    public void maxArea() throws Exception {

        final MaxArea m = new MaxArea();
        assertEquals(16, m.maxArea(new int[]{1,2,4,2,3,2,5,1}));
    }

}