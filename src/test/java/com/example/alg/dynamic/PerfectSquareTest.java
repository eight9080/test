package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class PerfectSquareTest {
    @Test
    public void numSquares() throws Exception {
        final PerfectSquare p = new PerfectSquare();
        assertEquals(3, p.numSquares(12));
        assertEquals(2, p.numSquares(13));
    }

}