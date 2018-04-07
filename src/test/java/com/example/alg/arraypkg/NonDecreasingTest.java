package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonDecreasingTest {
    @Test
    public void checkPossibility() throws Exception {
        final NonDecreasing n = new NonDecreasing();
        assertFalse(n.checkPossibility(new int[]{3,4,2,3}));
        assertTrue(n.checkPossibility(new int[]{4, 2, 3}));
        assertFalse(n.checkPossibility(new int[]{4, 2, 1}));
    }

}