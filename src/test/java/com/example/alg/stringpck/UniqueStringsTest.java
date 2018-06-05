package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueStringsTest {

    @Test
    public void isUniqueChars() {
        final UniqueStrings s = new UniqueStrings();
        assertTrue(s.isUniqueChars("abc"));
        assertFalse(s.isUniqueChars("aasd"));
    }
}