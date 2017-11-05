package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionListTest {
    @Test
    public void partition() throws Exception {

        final ListNode l6 = new ListNode(2);
        final ListNode l5 = new ListNode(5, l6);
        final ListNode l4 = new ListNode(2, l5);
        final ListNode l3 = new ListNode(3, l4);
        final ListNode l2 = new ListNode(4, l3);
        final ListNode l1 = new ListNode(1, l2);

        final PartitionList p = new PartitionList();
        final ListNode partition = p.partition(l1, 3);

        final ListNode lE6 = new ListNode(5);
        final ListNode lE5 = new ListNode(3, lE6);
        final ListNode lE4 = new ListNode(4, lE5);
        final ListNode lE3 = new ListNode(2, lE4);
        final ListNode lE2 = new ListNode(2, lE3);
        final ListNode lE1 = new ListNode(1, lE2);

        assertEquals(lE1, partition);


    }

}