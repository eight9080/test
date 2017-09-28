package com.example.alg.mappck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapSumTest {
    @Test
    public void sum() throws Exception {

        final MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertEquals(3, mapSum.sum("ap"));

        mapSum.insert("app", 2);
        assertEquals(5, mapSum.sum("ap"));

    }

}