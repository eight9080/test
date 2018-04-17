package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringTest {

    @Test
    public void decodeString() {

        final DecodeString d = new DecodeString();
        assertEquals("accaccacc", d.decodeString("3[a2[c]]"));
        assertEquals("aaabcbc", d.decodeString("3[a]2[bc]"));
        assertEquals("abcabccdcdcdef", d.decodeString("2[abc]3[cd]ef"));

    }
}