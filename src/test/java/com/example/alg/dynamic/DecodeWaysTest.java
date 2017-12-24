package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeWaysTest {
    @Test
    public void numDecodings() throws Exception {
        final DecodeWays d = new DecodeWays();
        assertEquals(1, d.numDecodings("10"));
        assertEquals(2, d.numDecodings("12"));
    }

}