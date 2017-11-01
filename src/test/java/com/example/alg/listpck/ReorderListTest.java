package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderListTest {
    @Test
    public void reorderList() throws Exception {
        final ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        final ListNode expected = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(3))));

        final ReorderList r = new ReorderList();
        r.reorderList(l1);
        assertEquals(expected, l1);

    }

}