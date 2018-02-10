package com.example.alg.stringpck;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FrequencySortTest {
    @Test
    public void frequencySort() throws Exception {
        final FrequencySort f = new FrequencySort();

        assertThat(f.frequencySort("tree"), Matchers.anyOf(is("eert"), is("eert")));
        assertThat(f.frequencySort("cccaaa"), Matchers.anyOf(is("cccaaa"), is("aaaccc")));
        assertThat(f.frequencySort("Aabb"), Matchers.anyOf(is("bbAa"), is("bbaA")));



    }

    @Test
    public void frequencySortWithPriority() throws Exception {
        final FrequencySort f = new FrequencySort();

        assertThat(f.frequencySortWithPriority("tree"), Matchers.anyOf(is("eert"), is("eert")));
        assertThat(f.frequencySortWithPriority("cccaaa"), Matchers.anyOf(is("cccaaa"), is("aaaccc")));
        assertThat(f.frequencySortWithPriority("Aabb"), Matchers.anyOf(is("bbAa"), is("bbaA")));



    }
}