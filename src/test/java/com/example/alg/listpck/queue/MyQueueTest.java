package com.example.alg.listpck.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
    @Test
    public void push() {

        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);

        assertEquals(1, obj.pop());
        assertEquals(2, obj.peek());
        assertFalse(obj.empty());

    }

}