package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    final LongestPalindrome l = new LongestPalindrome();

    @Test
    public void longestPalindromicSubstringLinear() throws Exception {
        assertEquals(3, l.longestPalindromicSubstringLinear("babad"));
    }

    @Test
    public void longestPalindrome() throws Exception {


        final LongestPalindrome l = new LongestPalindrome();
        assertEquals("bab",l.longestPalindrome("babad"));

        assertEquals("bb",l.longestPalindrome("cbbd"));


    }

}