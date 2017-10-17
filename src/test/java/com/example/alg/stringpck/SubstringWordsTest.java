package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SubstringWordsTest {
    @Test
    public void findSubstring() throws Exception {

        final SubstringWords s = new SubstringWords();
        assertEquals(Arrays.asList(13),
                s.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                        new String[]{"fooo","barr","wing","ding","wing"}));


        assertEquals(Arrays.asList(8),
                s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));

        assertEquals(Arrays.asList(6, 9, 12),
                s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        assertEquals(Arrays.asList(0, 9),
                s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));


    }

}