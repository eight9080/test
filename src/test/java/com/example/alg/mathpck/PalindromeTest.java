package com.example.alg.mathpck;

import com.example.alg.stringpck.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void isPalindrome() throws Exception {

        final Palindrome p = new Palindrome();
        assertTrue(p.isPalindrome(1001));
        assertTrue(p.isPalindrome(12321));
        assertFalse(p.isPalindrome(-1));

    }

}