package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadderTest {
    @Test
    public void ladderLength() throws Exception {
        final int ladderLength = new WordLadder().ladderLength("hit", "cog",
                new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log")));

        assertEquals(5, ladderLength);
    }

    @Test
    public void findLadders() throws Exception {
        final List<List<String>> ladders = new WordLadder().findLadders("hit", "cog",
                new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log")));

        List<List<String>> expectedResult = Arrays.asList(Arrays.asList("hit","hot","dot","dog","cog"),
        Arrays.asList("hit","hot","lot","log","cog"));


        assertEquals(expectedResult, ladders);
    }

}