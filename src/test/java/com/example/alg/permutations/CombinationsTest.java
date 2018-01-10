package com.example.alg.permutations;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void combine() throws Exception {

        final Combinations c = new Combinations();

        assertEquals(asList(asList(1)), c.combine(1,1));

        final List<List<Integer>> combine = c.combine(4, 2);

        assertThat(combine, Matchers.containsInAnyOrder(
                asList(2,4),
                asList(3,4),
                asList(2,3),
                asList(1,2),
                asList(1,3),
                asList(1,4)
        ));

    }

}