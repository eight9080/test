package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestCompletingWordTest {

    @Test
    public void shortestCompletingWord() {
        final ShortestCompletingWord s = new ShortestCompletingWord();
        final String shortestCompletingWord = s.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        assertEquals("steps", shortestCompletingWord);
    }

    @Test
    public void shortestCompletingWord2() {
        final ShortestCompletingWord s = new ShortestCompletingWord();
        final String shortestCompletingWord = s.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
        assertEquals("pest", shortestCompletingWord);
    }

    @Test
    public void shortestCompletingWord3() {
        final ShortestCompletingWord s = new ShortestCompletingWord();
        final String shortestCompletingWord = s.shortestCompletingWord("GrC8950",
                new String[]{"measure","other","every","base","according","level","meeting","none","marriage","rest"});
        assertEquals("according", shortestCompletingWord);
    }
}