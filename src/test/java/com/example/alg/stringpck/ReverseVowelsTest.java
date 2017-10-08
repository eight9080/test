package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseVowelsTest {
    @Test
    public void reverseVowels() throws Exception {
        assertEquals("holle", ReverseVowels.reverseVowels("hello"));
        assertEquals("leotcede", ReverseVowels.reverseVowels("leetcode"));
    }

}