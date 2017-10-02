package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordPatternTest {
    @Test
    public void wordPattern() throws Exception {

        assertFalse(WordPattern.wordPattern("abb", "dog cat cat fish"));
        assertTrue(WordPattern.wordPattern("abba", "dog cat cat dog"));
        assertFalse(WordPattern.wordPattern("abba", "dog cat cat fish"));
        assertFalse(WordPattern.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(WordPattern.wordPattern("abba", "dog dog dog dog"));
        assertTrue(WordPattern.wordPattern("aaaa", "dog dog dog dog"));
    }

    @Test
    public void wordPattern2() throws Exception {

        assertFalse(WordPattern.wordPattern2("abb", "dog cat cat fish"));
        assertTrue(WordPattern.wordPattern2("abba", "dog cat cat dog"));
        assertFalse(WordPattern.wordPattern2("abba", "dog cat cat fish"));
        assertFalse(WordPattern.wordPattern2("aaaa", "dog cat cat dog"));
        assertFalse(WordPattern.wordPattern2("abba", "dog dog dog dog"));
        assertTrue(WordPattern.wordPattern2("aaaa", "dog dog dog dog"));
    }


}