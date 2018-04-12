package com.example.alg.listpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.example.alg.listpck.ListNode.createList;
import static org.junit.Assert.*;

public class SplitListTest {

    @Test
    public void splitListToPartsEmpty() {

        final SplitList s = new SplitList();
        final ListNode[] listNodes = s.splitListToParts(null, 3);
        final ListNode[] expect1 = {
                null,
                null,
                null
        };

        assertArrayEquals(expect1, listNodes);
    }


    @Test
    public void splitListToParts() {

        final SplitList s = new SplitList();
        final ListNode[] listNodes = s.splitListToParts(createList(Arrays.asList(1, 2, 3)), 5);
        final ListNode[] expect1 = {
                createList(Collections.singletonList(1)),
                createList(Collections.singletonList(2)),
                createList(Collections.singletonList(3)),
                null,
                null
        };

        assertArrayEquals(expect1, listNodes);
    }


    @Test
    public void splitListToParts2() {

        final SplitList s = new SplitList();
        final ListNode[] listNodes = s.splitListToParts(
                createList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 3);
        final ListNode[] expect1 = {
                createList(Arrays.asList(1,2,3,4)),
                createList(Arrays.asList(5,6,7)),
                createList(Arrays.asList(8,9,10))
        };

        assertArrayEquals(expect1, listNodes);
    }
}
