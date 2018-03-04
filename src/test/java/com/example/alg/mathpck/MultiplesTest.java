package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplesTest {

    @Test
    public void solution() {
        assertEquals(78, new Multiples().solution(20));
        assertEquals(23, new Multiples().solution(10));
    }
}