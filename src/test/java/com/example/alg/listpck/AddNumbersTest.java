package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AddNumbersTest {
    @Test
    public void addTwoNumbers() throws Exception {
        final ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        final ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        final ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));

        final AddNumbers a = new AddNumbers();

        assertEquals(expected, a.addTwoNumbers(l1, l2));

    }

    @Test
    public void addTwoNumbers_carryLastDigit() throws Exception {
        final ListNode l1 = new ListNode(5);
        final ListNode l2 = new ListNode(5);
        final ListNode expected = new ListNode(0, new ListNode(1));

        final AddNumbers a = new AddNumbers();

        assertEquals(expected, a.addTwoNumbers(l1, l2));

    }

    @Test
    public void addLists() {

        final ListNode l1 = ListNode.createList(Arrays.asList(6, 1, 7));
        final ListNode l2 = ListNode.createList(Arrays.asList(2,9,5));

        final ListNode expect = ListNode.createList(Arrays.asList(9,1,2));

        final AddNumbers a = new AddNumbers();
        final ListNode result = a.addLists(l1, l2);

        assertEquals(expect, result);
    }
}