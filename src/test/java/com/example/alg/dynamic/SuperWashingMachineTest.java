package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuperWashingMachineTest {

    @Test
    public void findMinMoves() {

        final SuperWashingMachine s = new SuperWashingMachine();
        assertEquals(3, s.findMinMoves(new int[]{1,0,5}));
        assertEquals(2, s.findMinMoves(new int[]{0,3,0}));
        assertEquals(-1, s.findMinMoves(new int[]{0,2,0}));

    }
}