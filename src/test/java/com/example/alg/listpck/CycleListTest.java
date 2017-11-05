package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CycleListTest {
    @Test
    public void hasCycle() throws Exception {
        final ListNode l3 = new ListNode(3);
        final ListNode l7 = new ListNode(7,l3);
        final ListNode l6 = new ListNode(6, l7);
        final ListNode l5 = new ListNode(5, l6);
        final ListNode l4 = new ListNode(4, l5);
        l3.next=l4;
        final ListNode l2 = new ListNode(2, l3);
        final ListNode l1 = new ListNode(1, l2);

        final CycleList l = new CycleList();
        assertTrue(l.hasCycle(l1));

    }

    @Test
    public void hasNoCycle() throws Exception {

        final ListNode l7 = new ListNode(7);
        final ListNode l6 = new ListNode(6, l7);
        final ListNode l5 = new ListNode(5, l6);
        final ListNode l4 = new ListNode(4, l5);
        final ListNode l3 = new ListNode(3, l4);
        final ListNode l2 = new ListNode(2, l3);
        final ListNode l1 = new ListNode(1, l2);

        final CycleList l = new CycleList();
        assertFalse(l.hasCycle(l1));

    }

    @Test
    public void hasNoCycle2() throws Exception {

        final ListNode list = ListNode.createList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        final CycleList l = new CycleList();
        assertFalse(l.hasCycle(list));

    }

}