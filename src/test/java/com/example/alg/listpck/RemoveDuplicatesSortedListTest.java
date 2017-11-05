package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesSortedListTest {
    @Test
    public void deleteDuplicates2() throws Exception {

        final ListNode l5 = new ListNode(3);
        final ListNode l4 = new ListNode(2, l5);
        final ListNode l3 = new ListNode(1, l4);
        final ListNode l2 = new ListNode(1, l3);
        final ListNode l1 = new ListNode(1, l2);

        final RemoveDuplicatesSortedList r = new RemoveDuplicatesSortedList();

        final ListNode listNode = r.deleteDuplicates2(l1);

        final ListNode lE5 = new ListNode(3);
        final ListNode lE4 = new ListNode(2, lE5);

        assertEquals(lE4, listNode);

    }

    @Test
    public void deleteDuplicates2_case2() throws Exception {

        final ListNode l3 = new ListNode(2);
        final ListNode l2 = new ListNode(2, l3);
        final ListNode l1 = new ListNode(1, l2);

        final RemoveDuplicatesSortedList r = new RemoveDuplicatesSortedList();

        final ListNode listNode = r.deleteDuplicates2(l1);

        final ListNode lE5 = new ListNode(1);

        assertEquals(lE5, listNode);

    }

    @Test
    public void deleteDuplicates2_case3() throws Exception {

        final ListNode l2 = new ListNode(2);
        final ListNode l1 = new ListNode(1, l2);

        final RemoveDuplicatesSortedList r = new RemoveDuplicatesSortedList();

        final ListNode listNode = r.deleteDuplicates2(l1);

        final ListNode lE2 = new ListNode(2);
        final ListNode lE1 = new ListNode(1, lE2);

        assertEquals(lE1, listNode);

    }

    @Test
    public void deleteDuplicates2_case4() throws Exception {

        final ListNode l3 = new ListNode(2);
        final ListNode l2 = new ListNode(1, l3);
        final ListNode l1 = new ListNode(1, l2);

        final RemoveDuplicatesSortedList r = new RemoveDuplicatesSortedList();

        final ListNode listNode = r.deleteDuplicates2(l1);

        final ListNode lE5 = new ListNode(2);

        assertEquals(lE5, listNode);

    }

    @Test
    public void deleteDuplicates() throws Exception {

        final ListNode l7 = new ListNode(2);
        final ListNode l6 = new ListNode(1, l7);
        final ListNode l5 = new ListNode(1, l6);

        final RemoveDuplicatesSortedList r = new RemoveDuplicatesSortedList();

        final ListNode lE7 = new ListNode(2);
        final ListNode lE6 = new ListNode(1, lE7);

        final ListNode listNode = r.deleteDuplicates(l5);
        assertEquals(lE6, listNode);

    }

}