package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SummaryRangesTest {
    @Test
    public void summaryRanges() throws Exception {
        final SummaryRanges sR = new SummaryRanges();
        assertEquals(Arrays.asList("0->2", "4->5", "7"), sR.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        assertEquals(Arrays.asList("0->2", "4->7"), sR.summaryRanges(new int[]{0, 1, 2, 4, 5,6, 7}));
        assertEquals(Arrays.asList("0","2->4","6","8->9"), sR.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}