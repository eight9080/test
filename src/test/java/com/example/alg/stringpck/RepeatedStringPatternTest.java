package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedStringPatternTest {

    @Test
    public void repeatedSubstringPattern() {

        final RepeatedStringPattern r = new RepeatedStringPattern();
        assertFalse(r.repeatedSubstringPattern("aba"));
        assertTrue(r.repeatedSubstringPattern("abab"));
        assertTrue(r.repeatedSubstringPattern("abcabcabcabc"));
    }
}