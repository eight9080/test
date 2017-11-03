package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomListTest {
    @Test
    public void copyRandomList() throws Exception {

        final RandomListNode r1 = new RandomListNode(1);
        final RandomListNode r2 = new RandomListNode(2);
        final RandomListNode r3 = new RandomListNode(3);
        final RandomListNode r4 = new RandomListNode(4);
        final RandomListNode r5 = new RandomListNode(5);

        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;

        r1.random=r4;
        r2.random=r5;
        r3.random=r2;
        r4.random=r1;
        r5.random=r3;

        final RandomList rList = new RandomList();
        final RandomListNode copyRandomList = rList.copyRandomList(r1);

        assertEquals(copyRandomList, r1);


    }

    @Test
    public void copyRandomList2() throws Exception {

        final RandomListNode r1 = new RandomListNode(-1);
        final RandomListNode r2 = new RandomListNode(-1);

        r1.next=r2;

        r1.random=r2;
        r2.random=r1;

        final RandomList rList = new RandomList();
        final RandomListNode copyRandomList = rList.copyRandomList(r1);

        assertEquals(copyRandomList, r1);


    }

}