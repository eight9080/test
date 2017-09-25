package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void isValidPalindrome() throws Exception {
        assertTrue(Palindrome.isValidPalindrome("A man, a plan, a canal: Panama"));
    }

}