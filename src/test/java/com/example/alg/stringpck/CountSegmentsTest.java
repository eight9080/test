package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountSegmentsTest {

    @Test
    public void countSegments() {

        final CountSegments c = new CountSegments();
        assertEquals(0, c.countSegments("                "));

        assertEquals(5, c.countSegments("Hello, my name is John"));
    }

    @Test
    public void mostCommonWord() {

        final CountSegments countSegments = new CountSegments();
        final String mostCommonWord = countSegments.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        assertEquals("ball", mostCommonWord);
    }
}