package com.example.alg;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgNumberTest {
    @Test
    public void isPalindrome() throws Exception {

        assertTrue(AlgNumber.isPalindrome(1));
        assertFalse(AlgNumber.isPalindrome(20));
        assertTrue(AlgNumber.isPalindrome(22));
        assertFalse(AlgNumber.isPalindrome(102));
        assertTrue(AlgNumber.isPalindrome(101));
        assertTrue(AlgNumber.isPalindrome(1221));
        assertFalse(AlgNumber.isPalindrome(13321));
        assertTrue(AlgNumber.isPalindrome(13331));
        assertTrue(AlgNumber.isPalindrome(0));

    }

}