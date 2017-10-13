package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimplifyPathTest {

    @Test
    public void simplifyPath() {
        final SimplifyPath s = new SimplifyPath();
        assertEquals("/home", s.simplifyPath("/home/"));
        assertEquals("/c", s.simplifyPath("/a/./b/../../c/"));
        assertEquals("/", s.simplifyPath("/../"));
        assertEquals("/home/foo", s.simplifyPath("/home//foo/"));
    }

}