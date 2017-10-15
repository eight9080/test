package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BullCowTest {
    @Test
    public void getHint() throws Exception {

        final BullCow bullCow = new BullCow();
        assertEquals("0A4B", bullCow.getHint("1122", "2211"));
        assertEquals("1A3B", bullCow.getHint("1807", "7810"));
        assertEquals("1A1B", bullCow.getHint("1123", "0111"));
        assertEquals("1A0B", bullCow.getHint("1", "1"));
        assertEquals("0A0B", bullCow.getHint("1", "0"));
    }

}