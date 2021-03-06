package com.example.alg.mathpck;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SubsetsTest {
    final Subsets s = new Subsets();

    @Test
    public void subsetsWithDup() throws Exception {
        final List<List<Integer>> subsets = s.subsetsWithDup(new int[]{1, 2, 2});

        assertThat(subsets, Matchers.containsInAnyOrder(
                asList(2),
                asList(1),
                asList(1,2,2),
                asList(2,2),
                asList(1,2),
                Collections.emptyList()
        ));

    }

    @Test
    public void subsets() throws Exception {

        final List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});

        assertThat(subsets, Matchers.containsInAnyOrder(
                asList(3),
                asList(1),
                asList(2),
                asList(1,2,3),
                asList(1,3),
                asList(2,3),
                asList(1,2),
                Collections.emptyList()
                ));

    }

}