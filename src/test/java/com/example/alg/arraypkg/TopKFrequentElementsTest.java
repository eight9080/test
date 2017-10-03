package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TopKFrequentElementsTest {
    @Test
    public void topKFrequent() throws Exception {
        assertEquals(Arrays.asList(3, 5),
                TopKFrequentElements.topKFrequent(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2));

        assertEquals(Arrays.asList(1, 2),
                TopKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

    }

}