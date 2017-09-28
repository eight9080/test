package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuessNumberTest {
    @Test
    public void guessNumber() throws Exception {
        assertEquals(2, new GuessNumber(2).guessNumber(5));
        assertEquals(-1, new GuessNumber(3).guessNumber(2));
        assertEquals(22, new GuessNumber(22).guessNumber(55));
    }

}