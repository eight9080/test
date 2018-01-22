package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumberTest {
    @Test
    public void isUgly() throws Exception {
        final UglyNumber u = new UglyNumber();
        assertTrue(u.isUgly(6));
        assertTrue(u.isUgly(8));
        assertFalse(u.isUgly(14));


    }

}