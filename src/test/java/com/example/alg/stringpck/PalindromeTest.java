package com.example.alg.stringpck;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void isValidPalindrome() throws Exception {
        assertTrue(Palindrome.isValidPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void palindromePairs(){
        final List<List<Integer>> palindromePairs = Palindrome.palindromePairs(new String[]{"bat", "tab", "cat"});
        assertEquals(asList(asList(0,1), asList(1,0)), palindromePairs);
        assertEquals(asList(asList(0,2), asList(2,0)),
                Palindrome.palindromePairs(new String[]{"bat", "cat", "tab"}));

        assertEquals(asList(asList(0,2), asList(2,0), asList(1,2), asList(2,1)),
                Palindrome.palindromePairs(new String[]{"bob", "lol", "", "abcd"}));

        assertEquals(asList(asList(2,0)),
                Palindrome.palindromePairs(new String[]{"lolbat", "cat", "tab"}));
        assertEquals(asList(asList(1,2)),
                Palindrome.palindromePairs(new String[]{"lol", "batlol", "tab"}));
    }

}