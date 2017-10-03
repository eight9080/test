package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ClosestLocationsTest {
    @Test
    public void closestLocations() throws Exception {
        final List<List<Integer>> locations = ClosestLocations.closestLocations(3,
                asList(asList(1, 2), asList(3, 4), asList(1, -1)), 2);
        assertEquals(asList(asList(1, -1), asList(1, 2) ), locations);

    }

}