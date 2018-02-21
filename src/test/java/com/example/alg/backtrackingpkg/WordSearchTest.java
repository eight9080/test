package com.example.alg.backtrackingpkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void exist() {

        final WordSearch w = new WordSearch();
        final char[][] chars = {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
                    };

        assertTrue(w.exist(chars, "ABCCED"));
        assertTrue(w.exist(chars, "SEE"));
        assertFalse(w.exist(chars, "ABCB"));
    }
}