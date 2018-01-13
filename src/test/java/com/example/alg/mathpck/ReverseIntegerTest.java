package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {
    @Test
    public void reverse() throws Exception {

        final ReverseInteger r = new ReverseInteger();
        assertEquals(0, r.reverse(1_534_236_469));
        assertEquals(321, r.reverse(123));
        assertEquals(-321, r.reverse(-123));
        assertEquals(21, r.reverse(120));

    }

}