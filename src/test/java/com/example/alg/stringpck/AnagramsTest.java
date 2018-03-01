package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class AnagramsTest {
    @Test
    public void groupAnagrams() {
        final Anagrams a = new Anagrams();
        final List<List<String>> expected = asList(asList("ate", "eat", "tea"), asList("nat", "tan"), asList("bat"));
        final List<List<String>> lists = a.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        assertEquals(expected, lists);

    }

    @Test
    public void isAnagram() {

        final Anagrams a = new Anagrams();
        assertTrue(a.isAnagram("anagram", "nagaram"));
        assertFalse(a.isAnagram("rat", "car"));
    }
}