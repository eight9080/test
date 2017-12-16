package com.example.alg.sorting;

import com.example.alg.listpck.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortLinkedListTest {
    @Test
    public void sortList() throws Exception {

        final ListNode list = ListNode.createList(Arrays.asList(3, 5, 4, 2, 8));

        final SortLinkedList s = new SortLinkedList();
        final ListNode result = s.sortList(list);

        assertEquals(
                ListNode.createList(Arrays.asList(2,3,4,5,8)),
                result
        );

    }

}