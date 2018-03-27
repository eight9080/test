package com.example.alg.treepck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CountSmallerBinaryIndexTreeTest {

    @Test
    public void countSmaller() {

        final CountSmallerBinaryIndexTree c = new CountSmallerBinaryIndexTree();
        final List<Integer> smaller = c.countSmaller(new int[]{5, 2, 6, 1});
        assertEquals(Arrays.asList(2,1,1,0), smaller);

    }
}