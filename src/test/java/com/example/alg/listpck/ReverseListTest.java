package com.example.alg.listpck;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReverseListTest {
    @Test
    @Ignore
    public void reverseBetween() throws Exception {
        final ListNode list = ListNode.createList(Arrays.asList(1, 2,  3, 4));
        ReverseList r = new ReverseList();

        ListNode listNode = r.reverseBetween(list, 2, 4);

        final ListNode expList = ListNode.createList(Arrays.asList(1, 4,3,2,5));

        assertEquals(expList, listNode);


    }

    @Test
    public void reverseList() throws Exception {

        final ListNode list = ListNode.createList(Arrays.asList(1, 2,  3, 4));

        final ReverseList r = new ReverseList();
        final ListNode listNode = r.reverseList(list);

        final ListNode expList = ListNode.createList(Arrays.asList(4,3,2,1));

        assertEquals(expList, listNode);

    }

}