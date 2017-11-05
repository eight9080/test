package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionListTest {
    @Test
    public void getIntersectionNode() throws Exception {

        final ListNode c3 = new ListNode(7);
        final ListNode c2 = new ListNode(6, c3);
        final ListNode c1 = new ListNode(5, c2);

        final ListNode a3 = new ListNode(3, c1);
        final ListNode a2 = new ListNode(2, a3);
        final ListNode a1 = new ListNode(1, a2);

        final ListNode b2 = new ListNode(10, c1);
        final ListNode b1 = new ListNode(9, b2);

        final IntersectionList i = new IntersectionList();
        final ListNode intersectionNode = i.getIntersectionNode(a1, b1);

        assertEquals(c1, intersectionNode);

    }

}