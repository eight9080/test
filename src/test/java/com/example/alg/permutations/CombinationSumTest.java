package com.example.alg.permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class CombinationSumTest {

    @Test
    public void combinationSum() throws Exception {

        final CombinationSum c = new CombinationSum();
        final List<List<Integer>> lists = c.combinationSum(new int[]{2, 3, 6, 7}, 7);
        final List<List<Integer>> expect = Arrays.asList(Arrays.asList(7), Arrays.asList(2, 2, 3));

        assertThat(lists, containsInAnyOrder(
                asList(2,2,3),
                asList(7)));

    }

}