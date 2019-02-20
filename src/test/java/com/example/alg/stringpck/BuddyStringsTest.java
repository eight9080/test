package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyStringsTest {

    @Test
    public void buddyStrings() {

        final BuddyStrings b = new BuddyStrings();
        assertTrue(b.buddyStrings("abab", "abab"));
        assertTrue(b.buddyStrings("ab", "ba"));
        assertFalse(b.buddyStrings("ab", "ab"));
        assertTrue(b.buddyStrings("aa", "aa"));
        assertTrue(b.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        assertFalse(b.buddyStrings("", "aa"));

    }
}