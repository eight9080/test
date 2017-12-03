package com.example.alg.triepkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordDictionaryTest {
    @Test
    public void search() throws Exception {

        final WordDictionary w = new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        assertFalse(w.search("pad"));
        assertTrue(w.search("bad"));
        assertTrue(w.search(".ad"));
        assertTrue(w.search("b.."));
    }

    @Test
    public void search2() throws Exception {

        final WordDictionary w = new WordDictionary();
        w.addWord("a");
        w.addWord("ab");

        assertTrue(w.search("a"));
        assertTrue(w.search("a."));
        assertTrue(w.search("ab"));


        assertFalse(w.search(".a"));
        assertTrue(w.search(".b"));
        assertFalse(w.search("ab."));
        assertTrue(w.search("."));
        assertTrue(w.search(".."));

    }



}