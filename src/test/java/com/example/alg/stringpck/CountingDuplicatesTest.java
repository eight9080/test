package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountingDuplicatesTest {

    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("indivisibility"));
    }

    @Test
    public void duplicateCount() {
        assertEquals(2, CountingDuplicates.duplicateCount("aabBcde"));
        assertEquals(2, CountingDuplicates.duplicateCount("aabbcde"));
        assertEquals(2, CountingDuplicates.duplicateCount("Indivisibilities"));
        assertEquals(2, CountingDuplicates.duplicateCount("ABBA"));

    }

    @Test
    public void duplicateCount2() {

        assertEquals(2, CountingDuplicates.duplicateCount2("ABBA"));
    }
}