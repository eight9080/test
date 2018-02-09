package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindUniqueTest {
    @Test
    public void firstUniqChar() throws Exception {
        final FindUnique f = new FindUnique();
        assertEquals(0, f.firstUniqChar("leetcode"));
        assertEquals(2, f.firstUniqChar("loveleetcode"));

    }

}