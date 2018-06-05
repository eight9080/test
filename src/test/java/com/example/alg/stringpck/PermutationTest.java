package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationTest {

    @Test
    public void permutation() {
        final Permutation p = new Permutation();
        assertTrue(p.permutation("good", "doog"));
        assertFalse(p.permutation("god", "doog"));
        assertFalse(p.permutation("sddf", "doog"));

    }

    @Test
    public void permutation2() {
        final Permutation p = new Permutation();
        assertTrue(p.permutation2("good", "doog"));
        assertFalse(p.permutation2("god", "doog"));
        assertFalse(p.permutation2("sddf", "doog"));

    }
}