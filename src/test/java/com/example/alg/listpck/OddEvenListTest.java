package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddEvenListTest {
    @Test
    public void oddEvenList() throws Exception {

        final ListNode l7 = new ListNode(7);
        final ListNode l6 = new ListNode(6, l7);
        final ListNode l5 = new ListNode(5, l6);
        final ListNode l4 = new ListNode(4, l5);
        final ListNode l3 = new ListNode(3, l4);
        final ListNode l2 = new ListNode(2, l3);
        final ListNode l1 = new ListNode(1, l2);

        final OddEvenList o = new OddEvenList();
        final ListNode listNode = o.oddEvenList(l1);


        final ListNode lE6 = new ListNode(6);
        final ListNode lE4 = new ListNode(4, lE6);
        final ListNode lE2 = new ListNode(2, lE4);

        final ListNode lE7 = new ListNode(7, lE2);
        final ListNode lE5 = new ListNode(5, lE7);
        final ListNode lE3 = new ListNode(3, lE5);
        final ListNode lE1 = new ListNode(1, lE3);

        assertEquals(lE1, listNode);

    }

}