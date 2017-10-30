package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddNumbersTest {
    @Test
    public void addTwoNumbers() throws Exception {
        final AddNumbers.ListNode l1 = new AddNumbers.ListNode(2, new AddNumbers.ListNode(4, new AddNumbers.ListNode(3)));
        final AddNumbers.ListNode l2 = new AddNumbers.ListNode(5, new AddNumbers.ListNode(6, new AddNumbers.ListNode(4)));
        final AddNumbers.ListNode expected = new AddNumbers.ListNode(7, new AddNumbers.ListNode(0, new AddNumbers.ListNode(8)));

        final AddNumbers a = new AddNumbers();

        assertEquals(expected, a.addTwoNumbers(l1, l2));

    }

    @Test
    public void addTwoNumbers_carryLastDigit() throws Exception {
        final AddNumbers.ListNode l1 = new AddNumbers.ListNode(5);
        final AddNumbers.ListNode l2 = new AddNumbers.ListNode(5);
        final AddNumbers.ListNode expected = new AddNumbers.ListNode(0, new AddNumbers.ListNode(1));

        final AddNumbers a = new AddNumbers();

        assertEquals(expected, a.addTwoNumbers(l1, l2));

    }

}