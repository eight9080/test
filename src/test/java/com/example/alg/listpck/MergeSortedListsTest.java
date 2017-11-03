package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortedListsTest {
    @Test
    public void mergeTwoLists() throws Exception {
        final ListNode l7 = new ListNode(15);
        final ListNode l6 = new ListNode(13, l7);
        final ListNode l5 = new ListNode(12, l6);
        final ListNode l4 = new ListNode(8, l5);
        final ListNode l3 = new ListNode(7, l4);
        final ListNode l2 = new ListNode(5, l3);
        final ListNode l1 = new ListNode(1, l2);

        final ListNode r4 = new ListNode(11);
        final ListNode r3 = new ListNode(10, r4);
        final ListNode r2 = new ListNode(3, r3);
        final ListNode r1 = new ListNode(2, r2);

        final MergeSortedLists m = new MergeSortedLists();
        final ListNode listNode = m.mergeTwoLists(l1, r1);

        final ListNode lS7 = new ListNode(15);
        final ListNode lS6 = new ListNode(13, lS7);
        final ListNode lS5 = new ListNode(12, lS6);
        final ListNode rS4 = new ListNode(11, lS5);
        final ListNode rS3 = new ListNode(10, rS4);
        final ListNode lS4 = new ListNode(8, rS3);
        final ListNode lS3 = new ListNode(7, lS4);
        final ListNode lS2 = new ListNode(5, lS3);
        final ListNode rS2 = new ListNode(3, lS2);
        final ListNode rS1 = new ListNode(2, rS2);
        final ListNode lS1 = new ListNode(1, rS1);

        assertEquals(lS1, listNode);








    }

}