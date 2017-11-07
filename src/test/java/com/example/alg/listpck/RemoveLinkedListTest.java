package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RemoveLinkedListTest {
    @Test
    public void deleteNode() throws Exception {
        final ListNode l4 = new ListNode(4);
        final ListNode l3 = new ListNode(3, l4);
        final ListNode l2 = new ListNode(2, l3);
        final ListNode l1 = new ListNode(1, l2);

        final RemoveLinkedList r = new RemoveLinkedList();

        r.deleteNode(l3);

        final ListNode expectedList = ListNode.createList(
                Arrays.asList(1, 2, 4));

        assertEquals(expectedList, l1);

    }

    @Test
    public void removeNthFromEnd() throws Exception {
        final ListNode list = ListNode.createList(Arrays.asList(1, 2, 3, 4, 5));
        final RemoveLinkedList r = new RemoveLinkedList();

        final ListNode newList = r.removeNthFromEnd(list, 2);

        final ListNode expectedList = ListNode.createList(
                Arrays.asList(1, 2, 3, 5));

        assertEquals(expectedList, newList);

    }

    @Test
    public void removeElements() throws Exception {

        final ListNode list = ListNode.createList(Arrays.asList(1, 2, 6, 3, 4, 5, 6));

        final RemoveLinkedList r = new RemoveLinkedList();
        final ListNode newList = r.removeElements(list, 6);

        final ListNode expectedList = ListNode.createList(
                Arrays.asList(1, 2, 3, 4, 5));

        assertEquals(expectedList, newList);

    }

}