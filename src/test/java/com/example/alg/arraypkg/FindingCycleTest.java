package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindingCycleTest {
    @Test
    public void findDuplicate() throws Exception {
        assertEquals(1, FindingCycle.findDuplicate(new int[]{2,1,3,5,4,1,7,6}));

//        assertEquals(2, FindingCycle.findDuplicate(new int[]{2,1,3,5,4,2,7,6}));

    }

}