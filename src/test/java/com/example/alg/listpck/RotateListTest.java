package com.example.alg.listpck;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RotateListTest {

    @Test
    public void rotateRight() {

        final RotateList r = new RotateList();
        final ListNode listNode = r.rotateRight(ListNode.createList(Arrays.asList(1, 2, 3, 4, 5)), 2);
        final ListNode expect = ListNode.createList(Arrays.asList(4, 5,1,2,3));
        assertEquals(expect, listNode);
    }
}
