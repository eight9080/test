package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScrambleStringTest {

    @Test
    public void isScramble() {

        final ScrambleString s = new ScrambleString();
        assertTrue(s.isScramble("ab", "ba"));
        assertTrue(s.isScramble("a", "a"));
        assertTrue(s.isScramble("great", "rgeat"));
        assertTrue(s.isScramble("great", "rgtae"));
    }

    @Test
    public void isScramble2() {

        final ScrambleString s = new ScrambleString();
        assertTrue(s.isScramble2("ab", "ba"));
        assertTrue(s.isScramble2("a", "a"));
        assertTrue(s.isScramble2("great", "rgeat"));
        assertTrue(s.isScramble2("great", "rgtae"));
    }
}