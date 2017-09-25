package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceArrayTest {
    @Test
    public void longestConsecutive() throws Exception {
        assertEquals(4, SequenceArray.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}