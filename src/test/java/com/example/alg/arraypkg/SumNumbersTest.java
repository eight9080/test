package com.example.alg.arraypkg;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SumNumbersTest {
    @Test
    public void threeSum() throws Exception {

        final SumNumbers s = new SumNumbers();

        assertThat(s.threeSum(new int[]{1,-1,-1,0}),
                Matchers.containsInAnyOrder(asList(-1, 0, 1)));

        final List<List<Integer>> lists = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertThat(lists, Matchers.containsInAnyOrder(asList(-1, 0, 1),
                asList(-1, -1, 2)));

    }

    @Test
    public void twoSum() throws Exception {
        assertArrayEquals(new int[]{0,1}, SumNumbers.twoSum(new int[]{2,7,11,15}, 9));
    }

    @Test
    public void twoSumSortedArray() throws Exception {
        assertArrayEquals(new int[]{1,4}, SumNumbers.twoSumSortedArray(new int[]{1,2,3,4,5}, 7));
    }

    @Test
    public void minSubArrayLen() throws Exception {
        assertEquals(2, SumNumbers.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));

    }
}