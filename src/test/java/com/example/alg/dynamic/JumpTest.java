package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpTest {

    private Jump j = new Jump();

    @Test
    public void jump() throws Exception {
        assertEquals(2, j.jump(new int[]{2,3,1,1,4}));
    }


    @Test
    public void canJump() throws Exception {
        assertTrue(j.canJump(new int[]{2,3,8,2,0,4}));
        assertTrue(j.canJump(new int[]{2,5,0,0}));
        assertTrue(j.canJump(new int[]{2,5,0,0}));
        assertTrue(j.canJump(new int[]{2,3,1,1,4}));
        assertFalse(j.canJump(new int[]{3,2,1,0,4}));
    }
}