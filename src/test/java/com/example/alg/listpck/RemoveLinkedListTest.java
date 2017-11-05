package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RemoveLinkedListTest {
    @Test
    public void removeElements() throws Exception {

        final ListNode list = ListNode.createList(Arrays.asList(1, 2, 6, 3, 4, 5, 6));

        final RemoveLinkedList r = new RemoveLinkedList();
        final ListNode newList = r.removeElements(list, 6);

        final ListNode expectedList = ListNode.createList(
                Arrays.asList(1, 2, 3, 4, 5));

        assertEquals(expectedList, newList);

    }

}