package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularArrayTest {


    @Test
    public void circularArrayLoop() throws Exception {
        final CircularArray c = new CircularArray();
        assertFalse(c.circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
        assertTrue(c.circularArrayLoop(new int[]{1,2,3,4,5}));
        assertTrue(c.circularArrayLoop(new int[]{2,-1,1,2,2}));
        assertFalse(c.circularArrayLoop(new int[]{-1,2}));
    }

}