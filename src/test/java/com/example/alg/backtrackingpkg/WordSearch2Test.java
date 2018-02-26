package com.example.alg.backtrackingpkg;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearch2Test {

    @Test
    public void findWords() {
        final WordSearch2 w = new WordSearch2();

        final char[][] chars = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        final List<String> foundWords =
                w.findWords(chars, new String[]{"oath","pea","eat","rain"});

        assertThat(foundWords, Matchers.containsInAnyOrder("eat", "oath"));

    }
}