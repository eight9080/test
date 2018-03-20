package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class JewelsStonesTest {

    @Test
    public void numJewelsInStones() {

        final JewelsStones j = new JewelsStones();
        assertEquals(3, j.numJewelsInStones("aA", "aAAbbbb"));
        assertEquals(0, j.numJewelsInStones("z", "ZZ"));

    }
}