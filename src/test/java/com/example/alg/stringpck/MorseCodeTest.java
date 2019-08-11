package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MorseCodeTest {

    @Test
    public void uniqueMorseRepresentations() {
        final MorseCode morseCode = new MorseCode();
        final int uniqueMorseRepresentations = morseCode.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        assertEquals(2, uniqueMorseRepresentations);

    }
}