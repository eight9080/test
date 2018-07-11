package com.example.alg.listpck;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class NthToLastTest {

    @Test
    public void nthToLast() {

        final ListNode list = ListNode.createList(asList(1, 2, 3,4,5));
        final NthToLast nthToLast = new NthToLast();
        final ListNode listNode = nthToLast.nthToLast(list, 2);
        assertEquals(4, listNode.val);

    }
}