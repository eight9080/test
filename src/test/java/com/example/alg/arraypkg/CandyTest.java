package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {
    @Test
    public void candy() throws Exception {
        final Candy c = new Candy();
        assertEquals(13, c.candy(new int[]{1,2,3,1,4,2,1}));
        assertEquals(6, c.candy(new int[]{5,3,1}));

    }

}