package com.example.alg.heappck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianFinderTest {
    @Test
    public void addNum() throws Exception {
        final MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        assertEquals(1.5, m.findMedian(),0);
        m.addNum(3);
        assertEquals(2, m.findMedian(), 0);

    }

}