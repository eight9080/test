package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeekOpsTest {
    @Test
    public void findPeakElement() throws Exception {
        assertEquals(2, PeekOps.findPeakElement(new int []{1, 2, 3, 1}));
        assertEquals(0, PeekOps.findPeakElement(new int []{1, 1, 1, 1}));
        assertEquals(1, PeekOps.findPeakElement(new int []{1, 2}));
        assertEquals(5, PeekOps.findPeakElement(new int []{1, 1, 2, 3, 2, 4, 1}));
    }

}