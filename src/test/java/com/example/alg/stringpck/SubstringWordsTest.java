package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SubstringWordsTest {
    @Test
    public void lengthOfLongestSubstring() throws Exception {
        final SubstringWords s = new SubstringWords();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void lengthOfLastWord() throws Exception {
        final SubstringWords s = new SubstringWords();
        assertEquals(5, s.lengthOfLastWord("Hello World"));
    }

    @Test
    public void lengthOfLongestSubstringKDistinct() throws Exception {
        final SubstringWords s = new SubstringWords();
        assertEquals(11, s.lengthOfLongestSubstringKDistinct("abcadcacacaca", 3));
    }

    @Test
    public void lengthOfLongestSubstringTwoDistinct() throws Exception {
        final SubstringWords s = new SubstringWords();
        assertEquals(10, s.lengthOfLongestSubstringTwoDistinct("abcbbbbcccbdddadacb"));
    }

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