package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestBuyStockTest {
    @Test
    public void maxProfit4() throws Exception {
        assertEquals(10, b.maxProfit4(3, new int[]{2,5,7,1,4,3,1,3}));
    }

    @Test
    public void maxProfit3() throws Exception {
        /**
         * Prices: 1 4 5 7 6 3 2 9
         left = [0, 3, 4, 6, 6, 6, 6, 8]
         right= [8, 7, 7, 7, 7, 7, 7, 0]
         */
        assertEquals(13, b.maxProfit3(new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
    }

    @Test
    public void maxProfit2() throws Exception {
//        assertEquals(3, b.maxProfit2(new int[]{1,2,3,0,2}));
        assertEquals(1, b.maxProfit2(new int[]{1,2}));
        assertEquals(7, b.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(10, b.maxProfit2(new int[]{7, 1, 5, 8, 3, 6, 4}));
    }

    private  BestBuyStock b = new BestBuyStock();

    @Test
    public void maxProfit() throws Exception {

        assertEquals(2, b.maxProfit(new int[]{2,4,1}));
        assertEquals(5, b.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, b.maxProfit(new int[]{7, 6, 4, 3, 1}));

    }

}