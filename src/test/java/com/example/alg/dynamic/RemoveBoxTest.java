package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveBoxTest {
    @Test
    public void removeBoxes() throws Exception {
        RemoveBox r = new RemoveBox();
        assertEquals(17, r.removeBoxes(new int[]{1,2,3,3,2,1,1}));
    }

    @Test
    public void removeBoxRecursiv() throws Exception {
        RemoveBox r = new RemoveBox();
        assertEquals(17, r.removeBoxRecursiv("1233211"));
    }

    @Test
    public void removeBox() throws Exception {
        RemoveBox r = new RemoveBox();
        assertEquals(17, r.removeBox("1233211"));
    }

}