package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReverseListTest {

    @Test
    public void reverseKGroup_2() throws Exception {
        final ListNode list = ListNode.createList(Arrays.asList(1, 2));
        ReverseList r = new ReverseList();

        ListNode listNode = r.reverseKGroup(list, 2);

        final ListNode expList = ListNode.createList(Arrays.asList(2,1));

        System.out.println(ListNode.toStringList(listNode));
        assertEquals(expList, listNode);

    }

    @Test
    public void reverseKGroup() throws Exception {
        final ListNode list = ListNode.createList(Arrays.asList(1, 2,  3, 4,5));
        ReverseList r = new ReverseList();

        ListNode listNode = r.reverseKGroup(list, 2);

        final ListNode expList = ListNode.createList(Arrays.asList(2,1,4,3,5));

        System.out.println(ListNode.toStringList(listNode));
        assertEquals(expList, listNode);

    }

    @Test
    public void reverseKGroup_3k() throws Exception {
        final ListNode list = ListNode.createList(Arrays.asList(1, 2,  3, 4,5));
        ReverseList r = new ReverseList();

        ListNode listNode = r.reverseKGroup(list, 3);

        final ListNode expList = ListNode.createList(Arrays.asList(3, 2,1,4,5));

        System.out.println(ListNode.toStringList(listNode));
        assertEquals(expList, listNode);

    }


    @Test
    public void reverseBetween() throws Exception {
        final ListNode list = ListNode.createList(Arrays.asList(1, 2,  3, 4,5));
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