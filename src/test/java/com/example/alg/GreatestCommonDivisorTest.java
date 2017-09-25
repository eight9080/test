package com.example.alg;

import org.junit.Test;

public class GreatestCommonDivisorTest {
    @Test
    public void gcdRec() throws Exception {
        assert (GreatestCommonDivisor.gcdRec(4, 16) == 4);
        assert (GreatestCommonDivisor.gcdRec(16, 4) == 4);
        assert (GreatestCommonDivisor.gcdRec(15, 60) == 15);
        assert (GreatestCommonDivisor.gcdRec(15, 65) == 5);
        assert (GreatestCommonDivisor.gcdRec(1052, 52) == 4);
    }

    @Test
    public void gcdIterativ() throws Exception {
        assert (GreatestCommonDivisor.gcdIterativ(4, 16) == 4);
        assert (GreatestCommonDivisor.gcdIterativ(16, 4) == 4);
        assert (GreatestCommonDivisor.gcdIterativ(15, 60) == 15);
        assert (GreatestCommonDivisor.gcdIterativ(15, 65) == 5);
        assert (GreatestCommonDivisor.gcdIterativ(1052, 52) == 4);
    }

}