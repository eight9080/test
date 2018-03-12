package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateDigitsTest {

    @Test
    public void rotatedDigits() {

        final RotateDigits r = new RotateDigits();
        assertEquals(247, r.rotatedDigits(857));
        assertEquals(4, r.rotatedDigits(10));

    }
}