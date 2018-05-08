package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateTest {

    @Test
    public void rotateString() {

        final Rotate r = new Rotate();
        assertTrue(r.rotateString("abcde", "cdeab"));
        assertFalse(r.rotateString("abcde", "abced"));


    }
}