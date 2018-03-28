package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicateLettersTest {

    @Test
    public void removeDuplicateLetters() {

        final RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        assertEquals("abc", r.removeDuplicateLetters("bcabc"));
        assertEquals("acdb", r.removeDuplicateLetters("cbacdcbc"));

    }
}