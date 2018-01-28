package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class NthDigitTest {
    @Test
    public void findNthDigit() throws Exception {

        final NthDigit n = new NthDigit();
        assertEquals(2, n.findNthDigit(2147483647));

        assertEquals(3, n.findNthDigit(3));
        assertEquals(0, n.findNthDigit(11));

    }

}