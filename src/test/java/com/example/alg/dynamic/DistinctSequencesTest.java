package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctSequencesTest {
    @Test
    public void numDistinct() throws Exception {
        final DistinctSequences d = new DistinctSequences();
        final int numDistinct = d.numDistinct("rabbbit", "rabbit");
        assertEquals(3, numDistinct);

    }

}