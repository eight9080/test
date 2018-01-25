package com.example.alg.bitpkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberTest {
    @Test
    public void singleNumber() throws Exception {

        final SingleNumber s = new SingleNumber();
        assertEquals(1, s.singleNumber(new int[]{2,3,1,2,3}));


    }

}