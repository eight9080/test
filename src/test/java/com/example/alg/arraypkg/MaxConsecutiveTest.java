package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxConsecutiveTest {

    @Test
    public void findMaxConsecutiveOnes() {

        final MaxConsecutive m = new MaxConsecutive();
        assertEquals(3, m.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));

    }
}