package com.example.alg.mappck;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordDistanceTest {
    @Test
    public void shortest() throws Exception {
        final WordDistance dictionary = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        assertEquals(3, dictionary.shortest("coding", "practice"));
        assertEquals(1, dictionary.shortest("makes", "coding"));
    }

}