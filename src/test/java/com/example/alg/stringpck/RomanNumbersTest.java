package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumbersTest {
    @Test
    public void romanToInt() throws Exception {

        final RomanNumbers r = new RomanNumbers();

        assertEquals(621, r.romanToInt("DCXXI"));
        assertEquals(1, r.romanToInt("I"));
        assertEquals(5, r.romanToInt("V"));
        assertEquals(9, r.romanToInt("IX"));
        assertEquals(10, r.romanToInt("X"));
        assertEquals(50, r.romanToInt("L"));
        assertEquals(100, r.romanToInt("C"));
        assertEquals(500, r.romanToInt("D"));
        assertEquals(1000, r.romanToInt("M"));

    }

}