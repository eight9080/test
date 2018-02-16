package com.example.alg.arraypkg;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SumNumbersTest {
    @Test
    public void fourSumCount() throws Exception {
        final SumNumbers s = new SumNumbers();
        assertEquals(2, s.fourSumCount(new int[]{1,2}, new int[]{-2,-1},
                new int[]{-1,2}, new int[]{0,2}));
    }

    @Test
    public void fourSum() throws Exception {
        final SumNumbers s = new SumNumbers();
        final List<List<Integer>> result = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        assertThat(result, Matchers.containsInAnyOrder(
                    asList(-1,  0, 0, 1),
                    asList(-2, -1, 1, 2),
                    asList(-2,  0, 0, 2)
                ));
    }

    @Test
    public void checkSubarraySum() throws Exception {
        final SumNumbers s = new SumNumbers();
        assertTrue(s.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        assertFalse(s.checkSubarraySum(new int[]{0,1,0}, 0));
        assertTrue(s.checkSubarraySum(new int[]{0,0}, 0));
        assertFalse(s.checkSubarraySum(new int[]{23,2,6,4,7}, 0));
        assertTrue(s.checkSubarraySum(new int[]{23,2,6,4,7}, 6));
    }

    @Test
    public void subarraySum() throws Exception {
        final SumNumbers s = new SumNumbers();
        assertEquals(2, s.subarraySum(new int[]{1,1,1}, 2));
        assertEquals(2, s.subarraySum(new int[]{1,2,3}, 3));
    }

    @Test
    public void threeSumClosest() throws Exception {
        final SumNumbers s = new SumNumbers();
        assertEquals(2, s.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

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