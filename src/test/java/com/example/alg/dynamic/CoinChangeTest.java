package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {
    @Test
    public void change() throws Exception {
        final CoinChange c = new CoinChange();
        assertEquals(4, c.change(5, new int[]{1,2,5}));
        assertEquals(0, c.change(3, new int[]{2}));
        assertEquals(1, c.change(10, new int[]{10}));
    }

    @Test
    public void change2() throws Exception {
        final CoinChange c = new CoinChange();
        assertEquals(4, c.change2(5, new int[]{1,2,5}));
        assertEquals(0, c.change2(3, new int[]{2}));
        assertEquals(1, c.change2(10, new int[]{10}));
    }


    @Test
    public void coinChange() throws Exception {
        final CoinChange c = new CoinChange();

        assertEquals(-1, c.coinChange(new int[]{2147483647}, 2));

        assertEquals(3, c.coinChange(new int[]{1,2,5}, 11));

        assertEquals(-1, c.coinChange(new int[]{2}, 3));

    }

}