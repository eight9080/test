package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void isPalindrome() throws Exception {
        Palindrome p = new Palindrome();
        assertTrue(p.isPalindrome(ListNode.createList(Arrays.asList(1,2,3,3,2,1))));
        assertTrue(p.isPalindrome(ListNode.createList(Arrays.asList(1,2,3,4,3,2,1))));
        assertFalse(p.isPalindrome(ListNode.createList(Arrays.asList(1,2,3,3,1))));

    }

}