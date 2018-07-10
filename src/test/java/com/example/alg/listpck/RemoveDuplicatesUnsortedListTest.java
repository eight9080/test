package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class RemoveDuplicatesUnsortedListTest {

    @Test
    public void deleteDuplicates() {
        final ListNode list = ListNode.createList(asList(1, 2, 1, 2));
        final RemoveDuplicatesUnsortedList r = new RemoveDuplicatesUnsortedList();
        final ListNode result = r.deleteDuplicates(list);
        assertEquals(ListNode.createList(asList(1, 2)), result);
    }
}