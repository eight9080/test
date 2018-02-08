package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareNumbersTest {
    @Test
    public void isPerfectSquare() throws Exception {
        final SquareNumbers s = new SquareNumbers();
        assertTrue(s.isPerfectSquare(16));
        assertFalse(s.isPerfectSquare(14));
    }

    @Test
    public void judgeSquareSum() throws Exception {

        final SquareNumbers s = new SquareNumbers();
        assertTrue(s.judgeSquareSum(4));
        assertTrue(s.judgeSquareSum(5));
        assertFalse(s.judgeSquareSum(3));

    }

}