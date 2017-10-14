package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    @Test
    public void longestCommonPrefix() throws Exception {
        final LongestCommonPrefix l = new LongestCommonPrefix();
        assertEquals("", l.longestCommonPrefix(new String[]{"a", "b"}));
        assertEquals("a", l.longestCommonPrefix(new String[]{"a"}));
        assertEquals("abc", l.longestCommonPrefix(new String[]{"abca", "abcdd", "abcsss"}));

    }

}