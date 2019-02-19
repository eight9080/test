package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class EqualityEquationsTest {

    @Test
    public void equationsPossible() {
        final EqualityEquations e = new EqualityEquations();

        assertFalse(e.equationsPossible(new String[]{"a==b","b!=c","c==a"}));

        assertFalse(e.equationsPossible(new String[]{"a==b","b!=a"}));

        assertTrue(e.equationsPossible(new String[]{"b==b","b==e","e==c","d!=e"}));

        assertTrue(e.equationsPossible(new String[]{"b==a","a==b"}));

        assertTrue(e.equationsPossible(new String[]{"a==b","b==c","a==c"}));

        assertTrue(e.equationsPossible(new String[]{"c==c","b==d","x!=z"}));
    }
}