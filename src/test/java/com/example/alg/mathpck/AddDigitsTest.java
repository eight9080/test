package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddDigitsTest {
    @Test
    public void addDigits() throws Exception {
        final AddDigits a = new AddDigits();
        assertEquals(2, a.addDigits(38));

    }

}