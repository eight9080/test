package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionTest {
    @Test
    public void intersection() throws Exception {
        final Intersection intersection = new Intersection();
        final Integer[] result = intersection.intersectionTwoPointers(new int[]{1, 4, 2, 8, 0, 11}, new int[]{1, 5, 4, 0, 9, 7});
        assertArrayEquals(new Integer[]{0,1, 4}, result);
    }

    @Test
    public void intersectionBinarySearch() throws Exception {
        final Intersection intersection = new Intersection();
        final Integer[] result = intersection.intersectionBinarySearch(new int[]{1, 4, 2, 8, 0, 11}, new int[]{1, 5, 4, 0, 9, 7});
        assertArrayEquals(new Integer[]{0,1, 4}, result);
    }

    @Test
    public void intersect() {
        final Intersection i = new Intersection();
        assertArrayEquals(new int[]{2,2},
                i.intersect(new int[]{1,2,2,1}, new int[]{2,2}));
    }
}