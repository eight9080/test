package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumMatchingSequencingTest {

    @Test
    public void numMatchingSubseq() {

        final NumMatchingSequencing n = new NumMatchingSequencing();
        assertEquals(3,
                n.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));

    }
}
