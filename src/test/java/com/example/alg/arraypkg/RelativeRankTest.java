package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class RelativeRankTest {

    @Test
    public void findRelativeRanks() {

        final RelativeRank r = new RelativeRank();
        final String[] relativeRanks = r.findRelativeRanks(new int[]{5, 4, 3, 2, 1});

        final String[] expect = {
                "Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"
        };

        assertArrayEquals(expect, relativeRanks);
    }
}