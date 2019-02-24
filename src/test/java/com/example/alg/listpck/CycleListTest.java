package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class CycleListTest {
    @Test
    public void hasCycle() {
        final ListNode l3 = new ListNode(3);
        final ListNode l7 = new ListNode(7, l3);
        final ListNode l6 = new ListNode(6, l7);
        final ListNode l5 = new ListNode(5, l6);
        final ListNode l4 = new ListNode(4, l5);
        l3.next = l4;
        final ListNode l2 = new ListNode(2, l3);
        final ListNode l1 = new ListNode(1, l2);

        final CycleList l = new CycleList();
        assertTrue(l.hasCycle(l1));

    }

    @Test
    public void hasNoCycle() {

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
    public void hasNoCycle2() {

        final ListNode list = ListNode.createList(asList(1, 2, 3, 4, 5, 6, 7));

        final CycleList l = new CycleList();
        assertFalse(l.hasCycle(list));

    }

    @Test
    public void detectCycle_hasCycle() {

        final ListNode list = ListNode.createListCycle(asList(3, 2, 0, -4), 1);

        final ListNode listNode = new CycleList().detectCycle(list);
        assertNotNull(listNode);
        assertEquals(2, listNode.val);

    }

    @Test
    public void detectCycle_hasCycleFromHead() {

        final ListNode list = ListNode.createListCycle(asList(1,2), 0);

        final ListNode listNode = new CycleList().detectCycle(list);
        assertNotNull(listNode);
        assertEquals(1, listNode.val);

    }

    @Test
    public void detectCycle_hasCycleLong() {

        final ListNode list = ListNode.createListCycle(asList(-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5), 24);
        final ListNode listNode = new CycleList().detectCycle(list);
        assertNotNull(listNode);
        assertEquals(21, listNode.val);

    }

    @Test
    public void detectCycle_hasNoCycle() {

        final ListNode list = ListNode.createListCycle(asList(1), -1);

        final ListNode listNode = new CycleList().detectCycle(list);
        assertNull(listNode);

    }
}