package com.example.alg.mappck;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberAtomTest {

    @Test
    public void countOfAtoms() {
        final NumberAtom n = new NumberAtom();
        assertEquals("K4N2O14S4",
                n.countOfAtoms("K4(ON(SO3)2)2"));
        assertEquals("H2MgO2", n.countOfAtoms("Mg(OH)2"));
        assertEquals("H2O", n.countOfAtoms("H2O"));
    }
}