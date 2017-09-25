package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class WildCardMatchingTest {
    @Test
    public void isMatch() throws Exception {
//        assertTrue(WildCardMatching.isMatch("aab", "*ab"));
        assertTrue(WildCardMatching.isMatch("aaaabbbbcccc", "a*"));

    }

}