package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTest {
    @Test
    public void minWindow() throws Exception {
        final MinimumWindowSubstring m = new MinimumWindowSubstring();
        assertEquals("BANC", m.minWindow("ADOBECODEBANC", "ABC"));
    }

}