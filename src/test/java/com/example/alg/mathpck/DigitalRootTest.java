package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitalRootTest {

    @Test
    public void digitalRoot() {
        assertEquals(2, DigitalRoot.digitalRoot(493193));
        assertEquals(6, DigitalRoot.digitalRoot(132189));
        assertEquals(6, DigitalRoot.digitalRoot(942));
        assertEquals(7, DigitalRoot.digitalRoot(16));

    }
}