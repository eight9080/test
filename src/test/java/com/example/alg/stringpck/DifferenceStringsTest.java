package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class DifferenceStringsTest {
    @Test
    public void findTheDifference() throws Exception {
        final DifferenceStrings d = new DifferenceStrings();
        assertEquals('e', d.findTheDifference("abcd", "abcde"));
    }

}