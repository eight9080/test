package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumbersTest {
    @Test
    public void intToRoman() throws Exception {
        final RomanNumbers r = new RomanNumbers();
        assertEquals("MMM", r.intToRoman(3000));
        assertEquals("DCXXI", r.intToRoman(621));
        assertEquals("I", r.intToRoman(1));
        assertEquals("V", r.intToRoman(5));
        assertEquals("IX", r.intToRoman(9));
        assertEquals("X", r.intToRoman(10));
        assertEquals("L", r.intToRoman(50));
        assertEquals("C", r.intToRoman(100));
        assertEquals("D", r.intToRoman(500));
        assertEquals("M", r.intToRoman(1000));

    }

    @Test
    public void romanToInt() throws Exception {

        final RomanNumbers r = new RomanNumbers();
        assertEquals(3000, r.romanToInt("MMM"));
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