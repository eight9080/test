package com.example.alg.permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class CombinationSumTest {
    final CombinationSum c = new CombinationSum();

    @Test
    public void combinationSum3() throws Exception {

        final List<List<Integer>> lists1 = c.combinationSum3(3, 7);
        assertThat(lists1, containsInAnyOrder(
                asList(1,2,4)));

        final List<List<Integer>> lists2 = c.combinationSum3(3, 9);
        assertThat(lists2, containsInAnyOrder(
                asList(1,2,6), asList(1,3,5), asList(2,3,4)));
    }

    @Test
    public void combinationSum2() throws Exception {
        final List<List<Integer>> lists = c.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        assertThat(lists, containsInAnyOrder(
                asList(1,7),
                asList(1,2,5),
                asList(2,6),
                asList(1,1,6)));
    }

    @Test
    public void combinationSum() throws Exception {

        final List<List<Integer>> lists = c.combinationSum(new int[]{2, 3, 6, 7}, 7);
        final List<List<Integer>> expect = Arrays.asList(Arrays.asList(7), Arrays.asList(2, 2, 3));

        assertThat(lists, containsInAnyOrder(
                asList(2,2,3),
                asList(7)));

    }

}