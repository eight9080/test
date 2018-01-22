package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumberTest {
    @Test
    public void nthSuperUglyNumber() throws Exception {
        final UglyNumber u = new UglyNumber();
        assertEquals(32, u.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

    @Test
    public void nthUglyNumber() throws Exception {
        final UglyNumber u = new UglyNumber();
        assertEquals(12, u.nthUglyNumber(10));

    }

    @Test
    public void isUgly() throws Exception {
        final UglyNumber u = new UglyNumber();
        assertTrue(u.isUgly(6));
        assertTrue(u.isUgly(8));
        assertFalse(u.isUgly(14));


    }

}