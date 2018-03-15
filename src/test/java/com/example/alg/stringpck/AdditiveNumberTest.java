package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdditiveNumberTest {

    @Test
    public void isAdditiveNumber() {

        final AdditiveNumber a = new AdditiveNumber();

        assertFalse(a.isAdditiveNumber("19910011992"));
        assertTrue(a.isAdditiveNumber("199111992"));

        assertTrue(a.isAdditiveNumber("000"));
        assertTrue(a.isAdditiveNumber("123"));
        assertTrue(a.isAdditiveNumber("199100199"));
        assertTrue(a.isAdditiveNumber("112358"));

    }
}
