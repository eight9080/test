package com.example.alg.numpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidNumberTest {
    @Test
    public void isNumber() throws Exception {

        final ValidNumber v = new ValidNumber();
        assertTrue(v.isNumber("005047e+6"));
        assertTrue(v.isNumber(".2e81"));
        assertTrue(v.isNumber("-1."));
        assertFalse(v.isNumber("+++"));
        assertTrue(v.isNumber("0e1"));
        assertFalse(v.isNumber("1e."));
        assertFalse(v.isNumber(". 1"));
        assertFalse(v.isNumber("5e"));
        assertFalse(v.isNumber("0e"));
        assertTrue(v.isNumber("0."));
        assertTrue(v.isNumber("3."));
        assertFalse(v.isNumber(" ."));
        assertFalse(v.isNumber("e"));
        assertTrue(v.isNumber("2e10"));
        assertTrue(v.isNumber("0"));
        assertTrue(v.isNumber("0.1"));
        assertFalse(v.isNumber("abc"));
        assertFalse(v.isNumber("1 a"));

    }

}