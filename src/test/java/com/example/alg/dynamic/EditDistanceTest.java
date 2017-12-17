package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {
    @Test
    public void recEditDistance() throws Exception {

        final EditDistance e = new EditDistance();
        final int distance = e.recEditDistance("abcd".toCharArray(), "abc".toCharArray(), 0, 0);
        assertEquals(1, distance);

    }

    @Test
    public void minDistance() throws Exception {

        final EditDistance e = new EditDistance();
        final int minDistance = e.minDistance("abcd", "abc");
        assertEquals(1, minDistance);

    }

}