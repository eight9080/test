package com.example.alg.dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {

    final WordBreak w = new WordBreak();

    @Test
    public void wordBreak2() throws Exception {

        final List<String> phrases = w.wordBreak2("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog"));

        assertEquals(Arrays.asList( "cat sand dog", "cats and dog"), phrases);
    }


    @Test
    public void wordBreak() throws Exception {

        assertTrue(w.wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertTrue(w.wordBreak("coderleet", Arrays.asList("leet", "code", "coder")));


    }

}