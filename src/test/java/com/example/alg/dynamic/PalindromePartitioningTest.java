package com.example.alg.dynamic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PalindromePartitioningTest {
    @Test
    public void partition() throws Exception {

        final PalindromePartitioning p = new PalindromePartitioning();
        final List<List<String>> parts = p.partition("aab");
        assertEquals(asList( asList("a", "a", "b"), asList("aa", "b")), parts);

    }

}