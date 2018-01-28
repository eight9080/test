package com.example.alg.bitpkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberTest {
    final SingleNumber s = new SingleNumber();


    @Test
    public void singleNumber2() throws Exception {
        assertEquals(4, s.singleNumber2(new int[]{2,2,2,4}));

    }

    @Test
    public void singleNumber() throws Exception {

        assertEquals(1, s.singleNumber(new int[]{2,3,1,2,3}));


    }

}