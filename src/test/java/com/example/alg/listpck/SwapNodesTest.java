package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SwapNodesTest {
    @Test
    public void swapPairs() throws Exception {

        final ListNode list = ListNode.createList(Arrays.asList(1, 2,  3, 4));

        final SwapNodes s = new SwapNodes();

        final ListNode newList = s.swapPairs(list);

        final ListNode expectedList = ListNode.createList(
                Arrays.asList(2,1,4,3));

        assertEquals(expectedList, newList);
    }

    @Test
    public void swapPairs2() throws Exception {

        final ListNode list = ListNode.createList(Arrays.asList(1, 2,  3));

        final SwapNodes s = new SwapNodes();

        final ListNode newList = s.swapPairs(list);

        final ListNode expectedList = ListNode.createList(
                Arrays.asList(2,1,3));

        assertEquals(expectedList, newList);
    }

}