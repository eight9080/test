package com.example.alg.numpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecurringDigitsTest {

    @Test
    public void removeRecurringDigits() throws Exception {
        assertEquals(12983, RecurringDigits.removeRecurringDigits(1299888833));
        assertEquals(129832, RecurringDigits.removeRecurringDigits(1299888833222L));
    }

}