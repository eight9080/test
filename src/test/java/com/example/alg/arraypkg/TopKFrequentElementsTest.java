package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TopKFrequentElementsTest {
    @Test
    public void topKFrequent() throws Exception {
        assertEquals(Arrays.asList(3, 5),
                TopKFrequentElements.topKFrequent(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2));

        assertEquals(Arrays.asList(1, 2),
                TopKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

    }

    @Test
    public void topKFrequent_2words() {

        final TopKFrequentElements t = new TopKFrequentElements();
        final List<String> result = t.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        assertEquals(Arrays.asList("i", "love"), result);

    }

    @Test
    public void topKFrequent_4words() {

        final TopKFrequentElements t = new TopKFrequentElements();
        final List<String> result = t.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        assertEquals(Arrays.asList("the", "is", "sunny", "day"), result);

    }
}