package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void lengthOfLIS() throws Exception {

        final LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        final int lengthOfLIS = l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        assertEquals(4, lengthOfLIS);

    }

}