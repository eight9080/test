package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class GasStationTest {
    @Test
    public void canCompleteCircuit() throws Exception {
        final GasStation g = new GasStation();
        assertEquals(2, g.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{1,3,2,4,5}));
    }

}