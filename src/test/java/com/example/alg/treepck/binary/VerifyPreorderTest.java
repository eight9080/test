package com.example.alg.treepck.binary;

import org.junit.Test;

import static org.junit.Assert.*;

public class VerifyPreorderTest {
    final VerifyPreorder v = new VerifyPreorder();

    @Test
    public void isValidSerialization() throws Exception {
        assertTrue(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    @Test
    public void isValidSerialization_notvalid() throws Exception {
        assertFalse(v.isValidSerialization("1,#"));
    }

    @Test
    public void isValidSerialization_notvalid2() throws Exception {
        assertFalse(v.isValidSerialization("9,#,#,1"));
    }

    @Test
    public void isValidSerialization_noelems() throws Exception {
        assertTrue(v.isValidSerialization("#"));
    }

}