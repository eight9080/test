package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedStringMatchTest {

    @Test
    public void repeatedStringMatch() {

        final RepeatedStringMatch s = new RepeatedStringMatch();


        assertEquals(2, s.repeatedStringMatch("abababaaba", "aabaaba"));
        assertEquals(3, s.repeatedStringMatch("abcd", "cdabcdab"));
    }
}