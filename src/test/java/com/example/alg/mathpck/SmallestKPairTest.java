package com.example.alg.mathpck;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SmallestKPairTest {
    @Test
    public void kSmallestPairs() throws Exception {
        final SmallestKPair s = new SmallestKPair();

        assertThat(s.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3),
                Matchers.contains(new int[]{1, 2}, new int[]{1, 4}, new int[]{1, 6}));

        assertThat(s.kSmallestPairs(new int[]{1, 1,2}, new int[]{1,2,3}, 2),
                Matchers.contains(new int[]{1, 1}, new int[]{1, 1}));

        assertThat(s.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3),
                Matchers.contains(new int[]{1, 3}, new int[]{2,3}));

    }

}