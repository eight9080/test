package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringJava8Test {
    @Test
    public void join() throws Exception {
         assertEquals("a,b,c",StringJava8.join(new String[]{"a","b","c"}));
         assertEquals("a,null,c",StringJava8.join(new String[]{"a",null,"c"}));
    }

    @Test
    public void joinWithPrefixPostfix() throws Exception {
        assertEquals("[a,b,c]",StringJava8.joinWithPrefixPostfix(new String[]{"a","b","c"}));

    }

    @Test
    public void splitToListOfChar() throws Exception {
        assertEquals(Arrays.asList('a', 'b', 'c'), StringJava8.splitToListOfChar("abc"));
        assertEquals(Arrays.asList('a', 'b',' ', 'c'), StringJava8.splitToListOfChar("ab c"));
    }

    @Test
    public void split() throws Exception {
        assertEquals(Arrays.asList("a", "b", "c"), StringJava8.split("a,b,c"));

    }
}