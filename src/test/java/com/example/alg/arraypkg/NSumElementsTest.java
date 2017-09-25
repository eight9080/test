package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NSumElementsTest {
    @Test
    public void threeSum() throws Exception {
        final List<List<Integer>> lists = NSumElements.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        final List<List<Integer>> expectedLists = Arrays.asList( Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        assertEquals(expectedLists, lists);
    }

}