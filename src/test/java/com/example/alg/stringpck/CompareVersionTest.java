package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompareVersionTest {
    @Test
    public void compareVersion() throws Exception {
        final CompareVersion c = new CompareVersion();
        assertEquals(-1, c.compareVersion("0.1", "1.1"));
        assertEquals(1, c.compareVersion("1.1", "1.0"));
        assertEquals(0, c.compareVersion("0.1", "0.1"));
        assertEquals(-1, c.compareVersion("0.1", "13.37"));
        assertEquals(-1, c.compareVersion("0.1.0", "13.37"));
        assertEquals(-1, c.compareVersion("0.1.1", "13.37"));

    }

    @Test
    public void backspaceCompare() {
        final CompareVersion c = new CompareVersion();
        assertTrue(c.backspaceCompare("ab#c", "ad#c"));
        assertTrue(c.backspaceCompare("ab##", "c#d#"));
        assertTrue(c.backspaceCompare("a##c", "#a#c"));
        assertFalse(c.backspaceCompare("a#c", "b"));
    }
}