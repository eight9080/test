package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsomorphicStringsTest {
    @Test
    public void isIsomorphic() throws Exception {

        assertTrue(IsomorphicStrings.isIsomorphic("egg", "add"));
        assertFalse(IsomorphicStrings.isIsomorphic("foo", "bar"));
        assertTrue(IsomorphicStrings.isIsomorphic("dgg", "add"));

    }

}