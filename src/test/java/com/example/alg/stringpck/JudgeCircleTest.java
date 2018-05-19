package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeCircleTest {

    @Test
    public void judgeCircle() {

        final JudgeCircle j = new JudgeCircle();
        assertTrue(j.judgeCircle("UD"));
        assertFalse(j.judgeCircle("LL"));

    }
}