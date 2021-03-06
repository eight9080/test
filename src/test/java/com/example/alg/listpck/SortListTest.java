package com.example.alg.listpck;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    @Test
    public void linkSort(){

        final SortList s = new SortList();
        final ListNode list = ListNode.createList(Arrays.asList(1, 2, 2, 1, 2, 0, 2, 2));
        final ListNode listNode = s.linkSort(list);
        System.out.println(ListNode.toStringList(listNode));
        final List<Integer> expected = Arrays.asList(0, 1, 1, 2, 2, 2, 2, 2);
        assertEquals(ListNode.createList(expected), listNode);

    }

    @Test
    public void sortedList(){

        final Stream.Builder<String> builder = Stream.builder();
        builder.add("1")
        .add("2").add("3");

        final Stream<String> stream = builder.build();


        final SortList s = new SortList();
        final ListNode list = ListNode.createList(Arrays.asList(1, -2, -3, 4, -5));
        final ListNode listNodeResult = s.sortedList(list);
        final List<Integer> expected = Arrays.asList(-5, -3, -2, 1, 4);
        assertEquals(ListNode.createList(expected), listNodeResult);

    }

}
