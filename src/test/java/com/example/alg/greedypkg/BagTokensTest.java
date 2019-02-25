package com.example.alg.greedypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class BagTokensTest {

    @Test
    public void bagOfTokensScore() {
        final BagTokens b = new BagTokens();

        assertEquals(0, b.bagOfTokensScore(new int[]{100}, 50));
        assertEquals(1, b.bagOfTokensScore(new int[]{100, 200}, 150));
        assertEquals(2, b.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));

    }
}