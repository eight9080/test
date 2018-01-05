package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {
    @Test
    public void coinChange() throws Exception {
        final CoinChange c = new CoinChange();

        assertEquals(-1, c.coinChange(new int[]{2147483647}, 2));

        assertEquals(3, c.coinChange(new int[]{1,2,5}, 11));

        assertEquals(-1, c.coinChange(new int[]{2}, 3));

    }

}