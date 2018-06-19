package com.example.alg.listpck.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueue2STest {

    @Test
    public void add() {

        final MyQueue2S<Integer> queue = new MyQueue2S<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(3, queue.size());

        assertEquals(Integer.valueOf(1), queue.peek());
        assertEquals(Integer.valueOf(1), queue.remove());
        assertEquals(Integer.valueOf(2), queue.remove());

        assertEquals(1, queue.size());

        queue.add(4);
        queue.add(5);

        assertEquals(Integer.valueOf(3), queue.peek());
        assertEquals(Integer.valueOf(3), queue.remove());
        assertEquals(Integer.valueOf(4), queue.remove());
        assertEquals(Integer.valueOf(5), queue.remove());

    }
}