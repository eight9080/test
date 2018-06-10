package com.example.alg.hashpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContiguousArrayTest {

    @Test
    public void findMaxLength() {

        final ContiguousArray c = new ContiguousArray();
        assertEquals(2, c.findMaxLength(new int[]{0,1}));
        assertEquals(2, c.findMaxLength(new int[]{0,1,0}));

    }
}