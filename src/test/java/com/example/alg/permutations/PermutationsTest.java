package com.example.alg.permutations;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class PermutationsTest {
    @Test
    public void getPermutation() throws Exception {
        final Permutations p = new Permutations();
        assertEquals("132", p.getPermutation(3, 2));
    }

    @Test
    public void permuteUnique() throws Exception {
        final Permutations p = new Permutations();

        final List<List<Integer>> lists = p.permuteUnique(new int[]{1, 1, 2});

        assertThat(lists, containsInAnyOrder(
                asList(1, 1, 2),
                asList(1, 2, 1),
                asList(2, 1, 1)));
    }

    @Test
    public void permute() throws Exception {

        final Permutations p = new Permutations();


        final List<List<Integer>> lists = p.permute(new int[]{1, 2, 3});


        assertThat(lists, containsInAnyOrder(asList(1, 2, 3),
                asList(1, 3, 2),
                asList(2, 1, 3),
                asList(2, 3, 1),
                asList(3, 1, 2),
                asList(3, 2, 1)));
    }

    @Test
    public void permuteBackTracking() throws Exception {

        final Permutations p = new Permutations();


        final List<List<Integer>> lists = p.permuteBackTracking(new int[]{1, 2, 3});


        assertThat(lists, containsInAnyOrder(asList(1, 2, 3),
                asList(1, 3, 2),
                asList(2, 1, 3),
                asList(2, 3, 1),
                asList(3, 1, 2),
                asList(3, 2, 1)));
    }


}