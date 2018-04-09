package com.example.alg.listpck;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortListTest {

    @Test
    public void insertionSortList() {

        final SortList s = new SortList();
        final ListNode listNode = s.insertionSortList(ListNode.createList(
                Arrays.asList(4, 1, 3, 8, 9, 2)));
        final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 8, 9);
        assertEquals(ListNode.createList(expected), listNode);

    }
}
