package com.example.alg.permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class FactorCombinationsTest {
    @Test
    public void getFactors() throws Exception {
        final FactorCombinations f = new FactorCombinations();
        final List<List<Integer>> factors = f.getFactors(8);
        final List<List<Integer>> expect = asList(asList(2, 2, 2), asList(2, 4));
        assertEquals(expect, factors);
    }

}