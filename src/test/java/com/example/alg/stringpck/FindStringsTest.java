package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindStringsTest {

    @Test
    public void canConstruct() {

        final FindStrings f = new FindStrings();
        assertFalse(f.canConstruct("a", "b"));
        assertFalse(f.canConstruct("aa", "ab"));
        assertTrue(f.canConstruct("aa", "aab"));
    }

    @Test
    public void minStickers() {
        final FindStrings f = new FindStrings();
        assertEquals(3, f.minStickers(new String[]{"with", "example", "science"}, "thehat"));
        assertEquals(-1, f.minStickers(new String[]{"notice", "possible"},
                "basicbasic"));

    }
}