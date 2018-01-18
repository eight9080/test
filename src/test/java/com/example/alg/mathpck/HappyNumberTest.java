package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class HappyNumberTest {
    @Test
    public void isHappy() throws Exception {

        final HappyNumber h = new HappyNumber();
        assertTrue(h.isHappy(19));

    }

}